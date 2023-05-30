package com.mx.alternativecourses.api.domain.repository;

import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update.StudentUpdateInput;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

	Optional<StudentDomain> findByNameAndLastNameAndSecondLastName(
		String name,
		String lastName,
		Optional<String> secondLastName
	);

	Optional<StudentDomain> findByEmail(
		String email
	);
	boolean exists(Long id);
	void delete(Long id);
	Optional<StudentDomain> find(Long id);

	StudentDomain create(StudentCreateInput input);

	StudentDomain update(Long id, StudentUpdateInput input);

	List<StudentDomain> findAll();
}
