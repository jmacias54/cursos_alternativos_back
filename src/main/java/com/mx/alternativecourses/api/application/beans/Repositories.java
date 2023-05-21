package com.mx.alternativecourses.api.application.beans;


import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.model.UserDomain;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.User;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.user.JpaUserRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.user.UserCreateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.UserRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Repositories {

	@Bean
	public JpaUserRepository jpaUserRepository(
		UserRepositoryJpa userRepositoryJpa,
		Mapper<User, UserDomain> userToUserDomainMapper,
		UserCreateCreator userCreateCreator
	) {
		return new JpaUserRepository(userRepositoryJpa, userToUserDomainMapper, userCreateCreator);
	}
}
