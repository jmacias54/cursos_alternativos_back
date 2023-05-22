package com.mx.alternativecourses.api.domain.use_case.score.create;

import com.mx.alternativecourses.api.domain.exception.BadRequestException;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.domain.repository.ScoreRepository;
import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import com.mx.alternativecourses.api.domain.repository.SubjectRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateInput;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ScoreCreateUseCase {

	private final ScoreRepository scoreRepository;
	private final SubjectRepository subjectRepository;
	private final StudentRepository studentRepository;


	public ScoreDomain execute(ScoreCreateInput input) {
		Optional<ScoreDomain> domain = this.scoreRepository.findByStudentIdAndSubjectId(
			input.getStudentId(),
			input.getSubjectId()
		);

		if(domain.isPresent())
			throw new BadRequestException("score.exist");

		if(this.subjectRepository.find(input.getSubjectId()).isEmpty())
			throw new BadRequestException("subject.notFound");

		if(this.studentRepository.find(input.getStudentId()).isEmpty())
			throw new BadRequestException("student.notFound");


		return this.scoreRepository.create(input);
	}
}
