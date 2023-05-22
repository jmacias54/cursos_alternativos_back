package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update;

import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateInput;

public class StudentUpdateCreator {

	public Student create(StudentUpdateInput input, Student current) {
		input.getSecondLastName().ifPresent(current::setSecondLastName);
		input.getName().ifPresent(current::setName);
		input.getFirstLastName().ifPresent(current::setFirstLastName);
		input.getEmail().ifPresent(current::setEmail);
		return current;
	}
}
