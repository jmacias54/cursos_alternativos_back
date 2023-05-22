package com.mx.alternativecourses.api.application.controller.api.scores;


import com.mx.alternativecourses.api.application.configuration.constants.GlobalConstants;
import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.application.controller.api.scores.create.ScoreCreateRequest;
import com.mx.alternativecourses.api.application.controller.api.scores.detail.ScoreDetailResponse;
import com.mx.alternativecourses.api.application.controller.api.scores.update.ScoreUpdateRequest;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update.ScoreUpdateInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = GlobalConstants.SCORES, produces = MediaType.APPLICATION_JSON_VALUE)
public class ScoresApiController {


	private final Mapper<ScoreCreateRequest, ScoreCreateInput> scoreCreateRequestToScoreCreateInputMapper;
	private final Mapper<ScoreUpdateRequest, ScoreUpdateInput> scoreUpdateRequestToScoreUpdateInputMapper;
	private final Mapper<ScoreDomain, ScoreDetailResponse> scoreDomainToScoreDetailResponseMapper;
}
