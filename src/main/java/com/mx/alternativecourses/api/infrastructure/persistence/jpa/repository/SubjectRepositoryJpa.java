package com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository;

import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepositoryJpa extends JpaRepository<Subject, Long> {
}
