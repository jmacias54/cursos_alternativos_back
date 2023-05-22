package com.mx.alternativecourses.api.domain.use_case.subject.detail;

import com.mx.alternativecourses.api.domain.exception.BadRequestException;
import com.mx.alternativecourses.api.domain.model.SubjectDomain;
import com.mx.alternativecourses.api.domain.repository.SubjectRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.update.SubjectUpdateInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SubjectGetDetailUseCase {

	private final SubjectRepository subjectRepository;

	public SubjectDomain execute(Long id) {

		if(this.subjectRepository.find(id).isEmpty())
			throw new BadRequestException("subject.notFound");

		return this.subjectRepository.find(id).get();
	}
}
