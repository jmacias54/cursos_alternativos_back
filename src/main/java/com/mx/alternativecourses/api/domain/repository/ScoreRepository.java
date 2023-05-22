package com.mx.alternativecourses.api.domain.repository;

import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update.ScoreUpdateInput;

import java.util.Optional;

public interface ScoreRepository {

	ScoreDomain create(ScoreCreateInput input);

	ScoreDomain update(Long id,ScoreUpdateInput input);

	Optional<ScoreDomain> findById(Long id);

	Optional<ScoreDomain>  findByStudentIdAndSubjectId(Long studentId,Long subjectId);

	void delete(Long id);

}
