package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.exception.ItemNotFoundException;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.domain.repository.ScoreRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Score;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Subject;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update.ScoreUpdateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update.ScoreUpdateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.ScoreRepositoryJpa;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.StudentRepositoryJpa;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.SubjectRepositoryJpa;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class JpaScoreRepository implements ScoreRepository {

	private final ScoreRepositoryJpa scoreRepositoryJpa;
	private final SubjectRepositoryJpa subjectRepositoryJpa;
	private final StudentRepositoryJpa studentRepositoryJpa;
	private final ScoreCreateCreator scoreCreateCreator;
	private final ScoreUpdateCreator scoreUpdateCreator;
	private final Mapper<Score, ScoreDomain> scoreToScoreDomainMapper;

	@Override
	public ScoreDomain create(ScoreCreateInput input) {
		Optional<Subject> subject = this.subjectRepositoryJpa.findById(input.getSubjectId());
		Optional<Student> student = this.studentRepositoryJpa.findById(input.getStudentId());
		return this.scoreToScoreDomainMapper.map(
			this.scoreRepositoryJpa.save(
				this.scoreCreateCreator.create(
					input,
					student.get(),
					subject.get()
				)));
	}

	@Override
	public ScoreDomain update(Long id, ScoreUpdateInput input) {
		Optional<Student> student = Optional.empty();
		Optional<Subject> subject = Optional.empty();

		if(input.getStudentId().isPresent())
			subject = this.subjectRepositoryJpa.findById(input.getSubjectId().get());
		if(input.getStudentId().isPresent())
			student = this.studentRepositoryJpa.findById(input.getStudentId().get());

		Score score = this.scoreUpdateCreator.create(
			input,
			student,
			subject,
			this.scoreRepositoryJpa.findById(id).get()
		);

		return this.scoreToScoreDomainMapper.map(
			this.scoreRepositoryJpa.save(score));
	}

	@Override
	public Optional<ScoreDomain> findById(Long id) {
		return this.scoreRepositoryJpa.findById(id).map(this.scoreToScoreDomainMapper::map);
	}

	@Override
	public Optional<ScoreDomain> findByStudentIdAndSubjectId(Long studentId, Long subjectId) {
		return this.scoreRepositoryJpa.findByStudent_IdAndSubject_IdAndDateDeletedIsNull(studentId, subjectId)
			.map(this.scoreToScoreDomainMapper::map);
	}

	@Override
	public void delete(Long id) {
		Optional<Score> score = this.scoreRepositoryJpa.findById(id);

		if(score.isEmpty())
			new ItemNotFoundException("score.notFound");

		this.scoreRepositoryJpa.delete(score.get());

	}

	@Override
	public List<ScoreDomain> findAll() {
		return this.scoreRepositoryJpa.findAll()
			.stream()
			.map(this.scoreToScoreDomainMapper::map)
			.collect(Collectors.toList());
	}

	@Override
	public List<ScoreDomain> findByStudentId(Long studentId) {
		return this.scoreRepositoryJpa.findByStudent_IdAndDateDeletedIsNull(studentId)
			.stream()
			.map(this.scoreToScoreDomainMapper::map)
			.collect(Collectors.toList());
	}
}
