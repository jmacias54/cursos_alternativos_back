package com.mx.alternativecourses.api.domain.use_case.student.detail;


import com.mx.alternativecourses.api.domain.exception.ItemNotFoundException;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateInput;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public class StudentGetDetailUseCase {

	private final StudentRepository studentRepository;

	public StudentDomain execute(Long id) {
		Optional<StudentDomain> domain = this.studentRepository.find(id);

		if(domain.isEmpty()){
			throw new ItemNotFoundException("student.notFound");
		}

		return domain.get();
	}
}
