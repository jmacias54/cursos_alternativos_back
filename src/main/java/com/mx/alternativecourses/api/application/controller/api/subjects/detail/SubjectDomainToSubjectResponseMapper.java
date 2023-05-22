package com.mx.alternativecourses.api.application.controller.api.subjects.detail;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.model.SubjectDomain;

public class SubjectDomainToSubjectResponseMapper implements Mapper<SubjectDomain, SubjectResponse> {
	@Override
	public SubjectResponse map(SubjectDomain domain) {

		return new SubjectResponse(domain.getId(), domain.getName());
	}
}
