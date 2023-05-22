package com.mx.alternativecourses.api.domain.use_case.access.subject.delete;

import com.mx.alternativecourses.api.domain.exception.BadRequestException;
import com.mx.alternativecourses.api.domain.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SubjectDeleteUseCase {

	private final SubjectRepository subjectRepository;


	public void execute(Long id) {

		if(this.subjectRepository.find(id).isEmpty())
			throw new BadRequestException("subject.notFound");

		this.subjectRepository.delete(id);
	}
}
