package com.mx.alternativecourses.api.application.controller.api.student.detail;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.model.StudentDomain;

public class StudentDomainToStudentResponseMapper implements Mapper<StudentDomain, StudentResponse> {
	@Override
	public StudentResponse map(StudentDomain domain) {
		StudentResponse response = new StudentResponse(
			domain.getId(),
			domain.getName(),
			domain.getFirstLastName(),
			domain.getEmail()
		);
		domain.getSecondLastName().ifPresent(response::setSecondLastName);
		return response;
	}
}
