package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.user;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.model.UserDomain;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.User;

public class UserToUserDomainMapper implements Mapper<User, UserDomain> {

	@Override
	public UserDomain map(User input) {
		return new UserDomain(input.getId(), input.getUsername(), input.getPassword());
	}
}
