package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.exception.ItemNotFoundException;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update.StudentUpdateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update.StudentUpdateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.StudentRepositoryJpa;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class JpaStudentRepository implements StudentRepository {

	private final StudentRepositoryJpa studentRepositoryJpa;
	private final Mapper<Student, StudentDomain> studentToStudentDomainMapper;
	private final StudentUpdateCreator studentUpdateCreator;
	private final StudentCreateCreator studentCreateCreator;

	@Override
	public Optional<StudentDomain> findByNameAndLastNameAndSecondLastName(
		String name,
		String lastName,
		Optional<String> secondLastName
	) {


		return Optional.ofNullable(this.studentRepositoryJpa.findByNameAndFirstLastNameAndSecondLastNameAndDateDeletedIsNull(
				name,
				lastName,
				secondLastName.isEmpty() ? "" : secondLastName.get()
			))
			.map(this.studentToStudentDomainMapper::map);
	}

	@Override
	public Optional<StudentDomain> findByEmail(String email) {
		return Optional.ofNullable(this.studentRepositoryJpa.findByEmailAndDateDeletedIsNull(email))
			.map(this.studentToStudentDomainMapper::map);
	}

	@Override
	public boolean exists(Long id) {
		return this.studentRepositoryJpa.existsByIdAndDateDeletedIsNull(id);
	}

	@Override
	public Optional<StudentDomain> find(Long id) {
		return this.studentRepositoryJpa.findById(id).map(this.studentToStudentDomainMapper::map);
	}

	@Override
	public StudentDomain create(StudentCreateInput input) {
		Student student = this.studentCreateCreator.create(input);
		return this.studentToStudentDomainMapper.map(this.studentRepositoryJpa.save(student));
	}

	@Override
	public StudentDomain update(Long id, StudentUpdateInput input) {
		Optional<Student> exist = this.studentRepositoryJpa.findById(id);

		if(exist.isEmpty())
			throw new ItemNotFoundException("student.notFound");

		Student student = this.studentUpdateCreator.create(input, exist.get());
		return this.studentToStudentDomainMapper.map(this.studentRepositoryJpa.save(student));
	}

	@Override
	public List<StudentDomain> findAll() {
		return this.studentRepositoryJpa.findAll()
			.stream()
			.map(this.studentToStudentDomainMapper::map)
			.collect(Collectors.toList());
	}
}
