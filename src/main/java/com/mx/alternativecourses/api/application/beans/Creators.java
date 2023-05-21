package com.mx.alternativecourses.api.application.beans;

import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.user.UserCreateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.security.AuthenticationInfoCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.security.UserDetailsImplCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Creators {

	@Bean
	public UserCreateCreator userCreateCreator() {
		return new UserCreateCreator();
	}

	@Bean
	public AuthenticationInfoCreator authenticationInfoCreator() {
		return new AuthenticationInfoCreator();
	}

	@Bean
	public UserDetailsImplCreator userDetailsImplCreator() {
		return new UserDetailsImplCreator();
	}


}
