package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.user;

import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.User;

public class UserCreateCreator {
	public User create(String username, String passwordEncoded) {
		return new User()
			.setUsername(username)
			.setPassword(passwordEncoded);
	}
}
