package com.mx.alternativecourses.api.application.controller.api.scores.update;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update.ScoreUpdateInput;

public class ScoreUpdateRequestToScoreUpdateInputMapper implements Mapper<ScoreUpdateRequest, ScoreUpdateInput> {
	@Override
	public ScoreUpdateInput map(ScoreUpdateRequest request) {
		ScoreUpdateInput input = new ScoreUpdateInput();

		request.getSubjectId().ifPresent(input::setSubjectId);
		request.getScore().ifPresent(input::setScore);
		request.getRegistrationDate().ifPresent(input::setRegistrationDate);
		request.getStudentId().ifPresent(input::setStudentId);

		return input;
	}
}
