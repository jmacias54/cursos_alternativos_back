package com.mx.alternativecourses.api.application.controller.api.subjects.edit;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.update.SubjectUpdateInput;

public class SubjectUpdateRequestToSubjectUpdateInputMapper implements Mapper<SubjectUpdateRequest, SubjectUpdateInput> {
	@Override
	public SubjectUpdateInput map(SubjectUpdateRequest request) {
		return new SubjectUpdateInput(request.getName());
	}
}
