package com.mx.alternativecourses.api.domain.use_case.subject.list;

import com.mx.alternativecourses.api.domain.model.SubjectDomain;
import com.mx.alternativecourses.api.domain.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SubjectSearchUseCase {

	private final SubjectRepository subjectRepository;

	public List<SubjectDomain> execute() {
		return this.subjectRepository.findAll();
	}
}
