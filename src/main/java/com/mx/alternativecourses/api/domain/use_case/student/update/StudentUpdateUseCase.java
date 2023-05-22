package com.mx.alternativecourses.api.domain.use_case.student.update;

import com.mx.alternativecourses.api.domain.exception.ItemNotFoundException;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update.StudentUpdateInput;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class StudentUpdateUseCase {

	private final StudentRepository studentRepository;

	public StudentDomain execute(Long id , StudentUpdateInput input) {
		Optional<StudentDomain> domain = this.studentRepository.find(id);

		if(domain.isEmpty()){
			throw new ItemNotFoundException("student.notFound");
		}


		return this.studentRepository.update(id,input);
	}
}
