package com.mx.alternativecourses.api.domain.use_case.student.list;

import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StudentSearchUseCase {

	private final StudentRepository studentRepository;

	public List<StudentDomain> execute() {
		return this.studentRepository.findAll();
	}
}
