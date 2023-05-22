package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create;

import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.User;

public class StudentCreateCreator {
	public Student create(StudentCreateInput input) {
		Student student = new Student()
			.setName(input.getName())
			.setFirstLastName(input.getFirstLastName())
			.setEmail(input.getEmail());

		input.getSecondLastName().ifPresent(student::setSecondLastName);
		return student;
	}
}
