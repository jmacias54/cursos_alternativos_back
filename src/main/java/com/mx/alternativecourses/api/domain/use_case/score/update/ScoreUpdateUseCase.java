package com.mx.alternativecourses.api.domain.use_case.score.update;


import com.mx.alternativecourses.api.domain.exception.BadRequestException;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.domain.repository.ScoreRepository;
import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import com.mx.alternativecourses.api.domain.repository.SubjectRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update.ScoreUpdateInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ScoreUpdateUseCase {

	private final ScoreRepository scoreRepository;
	private final SubjectRepository subjectRepository;
	private final StudentRepository studentRepository;


	public ScoreDomain execute(Long id, ScoreUpdateInput input) {
		if(this.scoreRepository.findById(id).isEmpty())
			throw new BadRequestException("score.notFound");

		if(input.getSubjectId().isPresent() && input.getStudentId().isPresent()) {
			if(this.scoreRepository.findByStudentIdAndSubjectId(
				input.getStudentId().get(),
				input.getSubjectId().get()
			).isPresent())
				throw new BadRequestException("score.exist");
		}

		if(input.getSubjectId().isPresent()) {
			if(this.subjectRepository.find(input.getSubjectId().get()).isEmpty())
				throw new BadRequestException("subject.notFound");
		}

		if(input.getStudentId().isPresent()) {
			if(this.studentRepository.find(input.getStudentId().get()).isEmpty())
				throw new BadRequestException("student.notFound");
		}

		return this.scoreRepository.update(id, input);
	}
}
