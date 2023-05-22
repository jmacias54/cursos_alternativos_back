package com.mx.alternativecourses.api.domain.use_case.student.create;

import com.mx.alternativecourses.api.domain.exception.BadRequestException;
import com.mx.alternativecourses.api.domain.exception.ItemNotFoundException;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
public class StudentCrateUseCase {

	private final StudentRepository studentRepository;

	public StudentDomain execute(StudentCreateInput input) {
		Optional<StudentDomain> domain = this.studentRepository.findByNameAndLastNameAndSecondLastName(
			input.getName(),
			input.getFirstLastName(),
			input.getSecondLastName()
		);

		if(domain.isPresent())
			throw new BadRequestException("student.exist");

		if(this.studentRepository.findByEmail(input.getEmail()).isPresent())
			throw new BadRequestException("student.email.exist");


		return this.studentRepository.create(input);
	}
}
