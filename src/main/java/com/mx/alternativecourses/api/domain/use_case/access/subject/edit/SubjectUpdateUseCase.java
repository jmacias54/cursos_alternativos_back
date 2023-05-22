package com.mx.alternativecourses.api.domain.use_case.access.subject.edit;

import com.mx.alternativecourses.api.domain.exception.BadRequestException;
import com.mx.alternativecourses.api.domain.model.SubjectDomain;
import com.mx.alternativecourses.api.domain.repository.SubjectRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.update.SubjectUpdateInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SubjectUpdateUseCase {
	private final SubjectRepository subjectRepository;

	public SubjectDomain execute(Long id, SubjectUpdateInput input) {
		if(this.subjectRepository.findByName(input.getName()).isPresent())
			throw new BadRequestException("subject.name.exist");

		if(this.subjectRepository.find(id).isEmpty())
			throw new BadRequestException("subject.notFound");

		return this.subjectRepository.update(id, input);
	}
}
