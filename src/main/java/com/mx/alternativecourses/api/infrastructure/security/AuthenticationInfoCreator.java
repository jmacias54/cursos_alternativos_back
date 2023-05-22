package com.mx.alternativecourses.api.infrastructure.security;

import com.mx.alternativecourses.api.domain.model.AuthenticationInfo;
import org.springframework.security.core.GrantedAuthority;

import java.util.stream.Collectors;

public class AuthenticationInfoCreator {

	public AuthenticationInfo create(UserDetailsImpl user, String jwt) {
		return new AuthenticationInfo(
			user.getId(),
			user.getUsername(),
			user.getAuthorities()
				.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList()),
			jwt
		);
	}
	
}
