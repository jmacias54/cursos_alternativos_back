package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.model.SubjectDomain;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Subject;

public class SubjectToSubjectDomainMapper implements Mapper<Subject, SubjectDomain> {
	@Override
	public SubjectDomain map(Subject input) {
		return new SubjectDomain(input.getId(), input.getName());
	}
}
