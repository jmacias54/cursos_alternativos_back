package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Score;

public class ScoreToScoreDomainMapper implements Mapper<Score, ScoreDomain> {
	@Override
	public ScoreDomain map(Score score) {
		return new ScoreDomain(score.getId(),
			score.getScore(),
			score.getRegistrationDate(),
			score.getStudent().getId(),
			score.getSubject().getId(),
			score.getSubject().getName());
	}
}
