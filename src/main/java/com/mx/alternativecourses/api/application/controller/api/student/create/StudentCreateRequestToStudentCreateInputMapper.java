package com.mx.alternativecourses.api.application.controller.api.student.create;


import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateInput;

public class StudentCreateRequestToStudentCreateInputMapper implements Mapper<StudentCreateRequest, StudentCreateInput> {

	@Override
	public StudentCreateInput map(StudentCreateRequest request) {
		StudentCreateInput input = new StudentCreateInput(
			request.getName(),
			request.getFirstLastName(),
			request.getEmail());

		request.getSecondLastName().ifPresent(input::setSecondLastName);
		return input;
	}
}
