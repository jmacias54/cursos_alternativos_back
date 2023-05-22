package com.mx.alternativecourses.api.application.controller.api.subjects.create;


import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.create.SubjectCreateInput;

public class SubjectCreateRequestToSubjectCreateInputMapper implements Mapper<SubjectCreateRequest, SubjectCreateInput> {
	@Override
	public SubjectCreateInput map(SubjectCreateRequest request) {
		return new SubjectCreateInput(request.getName());
	}
}
