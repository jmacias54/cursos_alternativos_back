package com.mx.alternativecourses.api.infrastructure.security;

import com.mx.alternativecourses.api.domain.model.UserDomain;
import com.mx.alternativecourses.api.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	private final UserDetailsImplCreator userDetailsImplCreator;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		UserDomain clientDomain = userRepository.findByUsername(username)
			.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return this.userDetailsImplCreator.create(
			clientDomain,
			Collections.emptyList()
		);
	}

}
