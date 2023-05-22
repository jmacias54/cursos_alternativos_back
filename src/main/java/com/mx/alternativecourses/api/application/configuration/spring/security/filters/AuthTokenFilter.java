package com.mx.alternativecourses.api.application.configuration.spring.security.filters;

import com.mx.alternativecourses.api.application.configuration.constants.GlobalConstants;
import com.mx.alternativecourses.api.domain.services.security.TokenGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {

	private final TokenGenerator jwtTokenGenerator;
	private final UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
		log.info("Auth with JWT Filter");

		try {
			String jwt = parseJwt(request);
			if(nonNull(jwt) && this.jwtTokenGenerator.validateJwtToken(jwt)) {
				String username = this.jwtTokenGenerator.getUserNameFromJwtToken(jwt);

				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch(Exception e) {
			log.error("Cannot set user authentication %s", e);
		}

		filterChain.doFilter(request, response);

	}

	private String parseJwt(HttpServletRequest request) {
		log.info("parseJwt");

		String headerAuth = request.getHeader("Authorization");

		log.info("headerAuth",headerAuth);

		if(StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7);
		}

		return null;
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		log.debug("shouldNotFilter");

		String path = request.getServletPath();

		log.debug("path",path);

		return !path.startsWith(GlobalConstants.SIGNUP) &&
			!path.startsWith(GlobalConstants.SCORES) &&
			!path.startsWith(GlobalConstants.SUBJECTS) &&
			!path.startsWith(GlobalConstants.STUDENTS);
	}

}
