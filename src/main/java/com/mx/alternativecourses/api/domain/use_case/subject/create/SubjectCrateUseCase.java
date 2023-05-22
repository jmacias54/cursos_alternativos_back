package com.mx.alternativecourses.api.domain.use_case.subject.create;

import com.mx.alternativecourses.api.domain.exception.BadRequestException;
import com.mx.alternativecourses.api.domain.model.SubjectDomain;
import com.mx.alternativecourses.api.domain.repository.SubjectRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.create.SubjectCreateInput;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class SubjectCrateUseCase {

	private final SubjectRepository subjectRepository;

	public SubjectDomain execute(SubjectCreateInput input) {
		Optional<SubjectDomain> domain = this.subjectRepository.findByName(input.getName());

		if(domain.isPresent())
			throw new BadRequestException("subject.exist");

		return this.subjectRepository.create(input);
	}
}
