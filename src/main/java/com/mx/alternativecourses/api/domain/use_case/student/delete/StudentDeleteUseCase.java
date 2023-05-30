package com.mx.alternativecourses.api.domain.use_case.student.delete;

import com.mx.alternativecourses.api.domain.exception.BadRequestException;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public class StudentDeleteUseCase {

	private final StudentRepository studentRepository;

	public void execute(Long id) {
		Optional<StudentDomain> student = this.studentRepository.find(id);

		if(!student.isPresent())
			throw new BadRequestException("student.notFound");

		this.studentRepository.delete(id);
	}
}
