package com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository;

import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
