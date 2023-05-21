package com.mx.alternativecourses.api.infrastructure.persistence.security;

import com.mx.alternativecourses.api.domain.model.AuthenticationInfo;
import com.mx.alternativecourses.api.domain.services.security.TokenGenerator;
import com.mx.alternativecourses.api.domain.services.security.UserAuthenticationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
public class SecurityAuthenticationManager implements UserAuthenticationManager {

	private final AuthenticationManager authenticationManager;
	private final TokenGenerator jwtTokenGenerator;
	private final AuthenticationInfoCreator authenticationInfoCreator;

	@Override
	public AuthenticationInfo authenticate(String username, String password) {
		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(username, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return this.authenticationInfoCreator.create(
			(UserDetailsImpl)authentication.getPrincipal(),
			jwtTokenGenerator.generateJwtToken(authentication)
		);
	}

}
