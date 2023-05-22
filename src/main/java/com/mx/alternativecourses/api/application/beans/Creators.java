package com.mx.alternativecourses.api.application.beans;

import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update.ScoreUpdateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update.StudentUpdateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.user.UserCreateCreator;
import com.mx.alternativecourses.api.infrastructure.security.AuthenticationInfoCreator;
import com.mx.alternativecourses.api.infrastructure.security.UserDetailsImplCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Creators {

	@Bean
	public ScoreCreateCreator scoreCreateCreator() {
		return new ScoreCreateCreator();
	}

	@Bean
	public ScoreUpdateCreator scoreUpdateCreator() {
		return new ScoreUpdateCreator();
	}

	@Bean
	public StudentUpdateCreator studentUpdateCreator() {
		return new StudentUpdateCreator();
	}

	@Bean
	public StudentCreateCreator studentCreateCreator() {
		return new StudentCreateCreator();
	}

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
