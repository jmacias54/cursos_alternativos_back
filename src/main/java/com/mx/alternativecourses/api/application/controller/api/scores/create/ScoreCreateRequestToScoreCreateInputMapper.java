package com.mx.alternativecourses.api.application.controller.api.scores.create;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateInput;

public class ScoreCreateRequestToScoreCreateInputMapper implements Mapper<ScoreCreateRequest, ScoreCreateInput> {
	@Override
	public ScoreCreateInput map(ScoreCreateRequest request) {
		return new ScoreCreateInput(
			request.getStudentId(),
			request.getSubjectId(),
			request.getScore(),
			request.getRegistrationDate()
		);
	}
}
