package com.mx.alternativecourses.api.infrastructure.security.jwt;

import com.mx.alternativecourses.api.application.configuration.properties.TokenProperties;
import com.mx.alternativecourses.api.domain.services.security.TokenGenerator;
import com.mx.alternativecourses.api.infrastructure.security.UserDetailsImpl;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;

import java.util.Date;

@RequiredArgsConstructor
@Slf4j
public class JwtTokenGenerator implements TokenGenerator {

	private final TokenProperties tokenProperties;

	@Override
	public String generateJwtToken(Authentication authentication) {
		log.info("Generate JWT token");

		UserDetailsImpl userPrincipal = (UserDetailsImpl)authentication.getPrincipal();

		return generateTokenFromUsername(userPrincipal.getUsername());
	}

	@Override
	public String generateTokenFromUsername(String username) {
		log.info("Generate token from username {}", username);

		return Jwts.builder()
			.setSubject(username)
			.setIssuedAt(new Date())
			.setExpiration(new Date((new Date()).getTime() + this.tokenProperties.getJwtExpirationMs()))
			.signWith(SignatureAlgorithm.HS512, this.tokenProperties.getJwtSecret()).compact();
	}

	@Override
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser()
			.setSigningKey(this.tokenProperties.getJwtSecret())
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
	}

	@Override
	public boolean validateJwtToken(String authToken) {
		log.info("Validate JWT Token");

		try {
			Jwts.parser()
				.setSigningKey(this.tokenProperties.getJwtSecret())
				.parseClaimsJws(authToken);
			return true;
		} catch(SignatureException e) {
			log.error("Invalid JWT signature: {}", e.getMessage());
		} catch(MalformedJwtException e) {
			log.error("Invalid JWT token: {}", e.getMessage());
		} catch(ExpiredJwtException e) {
			log.error("JWT token is expired: {}", e.getMessage());
		} catch(UnsupportedJwtException e) {
			log.error("JWT token is unsupported: {}", e.getMessage());
		} catch(IllegalArgumentException e) {
			log.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}

}
