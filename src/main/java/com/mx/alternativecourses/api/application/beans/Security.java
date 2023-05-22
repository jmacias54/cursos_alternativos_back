package com.mx.alternativecourses.api.application.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.alternativecourses.api.application.configuration.properties.TokenProperties;
import com.mx.alternativecourses.api.application.configuration.spring.security.filters.AuthTokenFilter;
import com.mx.alternativecourses.api.domain.repository.UserRepository;
import com.mx.alternativecourses.api.domain.services.security.TokenGenerator;
import com.mx.alternativecourses.api.domain.services.security.UserAuthenticationManager;
import com.mx.alternativecourses.api.infrastructure.security.*;
import com.mx.alternativecourses.api.infrastructure.security.crypto.BCryptPasswordEncoderService;
import com.mx.alternativecourses.api.infrastructure.security.jwt.JwtTokenGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
public class Security {

	@Bean
	public AuthTokenFilter authTokenFilter(
		TokenGenerator tokenGenerator,
		UserDetailsService userDetailsService
	) {
		return new AuthTokenFilter(tokenGenerator, userDetailsService);
	}

	@Bean
	public AuthenticationManager authenticationManager(WebSecurityConfigurerAdapter webSecurityConfigurerAdapter) throws Exception {
		return webSecurityConfigurerAdapter.authenticationManagerBean();
	}

	@Bean
	public UserAuthenticationManager userAuthenticationManager(
		AuthenticationManager authenticationManager,
		TokenGenerator jwtTokenGenerator,
		AuthenticationInfoCreator authenticationInfoCreator
	) {
		return new SecurityAuthenticationManager(authenticationManager, jwtTokenGenerator, authenticationInfoCreator);
	}

	@Bean
	public AuthenticationEntryPoint authEntryPointJwt(ObjectMapper objectMapper) {
		return new AuthEntryPointJwtStarter(objectMapper);
	}

	@Bean
	public UserDetailsService userDetailsService(
		UserRepository userRepository,
		UserDetailsImplCreator userDetailsImplCreator
	) {
		return new UserDetailsServiceImpl(userRepository, userDetailsImplCreator);
	}


	@Bean
	public TokenGenerator tokenGenerator(TokenProperties tokenProperties) {
		return new JwtTokenGenerator(tokenProperties);
	}

	@Bean
	public PasswordEncoder passwordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		return new BCryptPasswordEncoderService(bCryptPasswordEncoder);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
