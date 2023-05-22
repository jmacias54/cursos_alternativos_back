package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.exception.ItemNotFoundException;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.domain.repository.ScoreRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Score;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update.ScoreUpdateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.ScoreRepositoryJpa;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public class JpaScoreRepository implements ScoreRepository {

	private final ScoreRepositoryJpa scoreRepositoryJpa;
	private final Mapper<Score, ScoreDomain> scoreToScoreDomainMapper;

	@Override
	public ScoreDomain create(ScoreCreateInput input) {
		return null;
	}

	@Override
	public ScoreDomain update(Long id, ScoreUpdateInput input) {
		return null;
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
}
