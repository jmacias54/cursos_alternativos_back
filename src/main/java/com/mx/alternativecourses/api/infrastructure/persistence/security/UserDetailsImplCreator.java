package com.mx.alternativecourses.api.infrastructure.persistence.security;

import com.mx.alternativecourses.api.domain.model.UserDomain;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImplCreator {

	public UserDetails create(UserDomain user, List<String> authoritiesList) {
		return new UserDetailsImpl(
			user.getId(),
			user.getName(),
			user.getPassword(),
			authoritiesList.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList())
		);
	}

}
