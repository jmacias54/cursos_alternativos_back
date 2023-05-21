package com.mx.alternativecourses.api.domain.repository;

import com.mx.alternativecourses.api.domain.model.UserDomain;

import java.util.Optional;

public interface UserRepository {

	Optional<UserDomain> findByUsername(String username);

	boolean exists(Long id);

	Optional<UserDomain> find(Long id);

	Optional<Long> find(String username);

	UserDomain create(String username, String passwordEncoded);
}
