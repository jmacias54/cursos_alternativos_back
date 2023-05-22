package com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository;


import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepositoryJpa extends JpaRepository<Student, Long> {

	Student findByNameAndFirstLastNameAndSecondLastNameAndDateDeletedIsNull(
		String name,
		String lastName,
		String secondLastName
	);

	Student findByEmailAndDateDeletedIsNull(
		String email
	);

	boolean existsByIdAndDateDeletedIsNull(Long id);

}
