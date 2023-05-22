package com.mx.alternativecourses.api.application.controller.api.scores.detail;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;

public class ScoreDomainToScoreDetailResponseMapper implements Mapper<ScoreDomain, ScoreDetailResponse> {
	@Override
	public ScoreDetailResponse map(ScoreDomain domain) {
		return new ScoreDetailResponse(
			domain.getId(),
			domain.getStudentId(),
			domain.getSubjectId(),
			domain.getScore(),
			domain.getRegistrationDate()
		);
	}
}
