package com.mx.alternativecourses.api.application.controller.api.student.update;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update.StudentUpdateInput;

public class StudentUpdateRequestToStudentUpdateInputMapper implements Mapper<StudentUpdateRequest, StudentUpdateInput> {
	@Override
	public StudentUpdateInput map(StudentUpdateRequest request) {
		StudentUpdateInput input = new StudentUpdateInput();
		request.getName().ifPresent(input::setName);
		request.getSecondLastName().ifPresent(input::setSecondLastName);
		request.getFirstLastName().ifPresent(input::setFirstLastName);
		request.getEmail().ifPresent(input::setEmail);

		return input;
	}
}
