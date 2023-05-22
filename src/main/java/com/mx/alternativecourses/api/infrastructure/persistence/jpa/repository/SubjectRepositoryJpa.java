package com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository;

import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepositoryJpa extends JpaRepository<Subject, Long> {

	Optional<Subject> findByNameAndDateDeletedIsNull(String name);
}
