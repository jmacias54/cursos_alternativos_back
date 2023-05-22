package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;

public class StudentToStudentDomainMapper implements Mapper<Student, StudentDomain> {
	@Override
	public StudentDomain map(Student input) {
		StudentDomain domain = new StudentDomain(
			input.getId(),
			input.getName(),
			input.getFirstLastName(),
			input.getEmail()
		);
		input.getSecondLastName().ifPresent(domain::setSecondLastName);
		return domain;
	}
}
