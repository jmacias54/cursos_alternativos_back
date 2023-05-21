package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.user;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.model.UserDomain;
import com.mx.alternativecourses.api.domain.repository.UserRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.User;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.UserRepositoryJpa;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository {

	private final UserRepositoryJpa userRepositoryJpa;
	private final Mapper<User, UserDomain> userToUserDomainMapper;
	private final UserCreateCreator userCreateCreator;

	@Override
	public Optional<UserDomain> findByUsername(String username) {
		Optional<User> user = Optional.ofNullable(this.userRepositoryJpa.findByUsername(username));
		return user.map(this.userToUserDomainMapper::map);
	}

	@Override
	public boolean exists(Long id) {
		return this.userRepositoryJpa.existsById(id);
	}


	@Override
	public Optional<UserDomain> find(Long id) {
		return this.userRepositoryJpa.findById(id)
			.map(this.userToUserDomainMapper::map);
	}

	@Override
	public Optional<Long> find(String username) {
		return Optional.ofNullable(this.userRepositoryJpa.findByUsername(username)).map(User::getId);
	}

	@Override
	public UserDomain create(String username, String passwordEncoded) {
		User user = this.userRepositoryJpa.save(this.userCreateCreator.create(username, passwordEncoded));
		return this.userToUserDomainMapper.map(user);
	}
}
