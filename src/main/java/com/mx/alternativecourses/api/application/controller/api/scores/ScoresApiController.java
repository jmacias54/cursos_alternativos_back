package com.mx.alternativecourses.api.application.controller.api.scores;


import com.mx.alternativecourses.api.application.configuration.constants.GlobalConstants;
import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.application.controller.api.scores.create.ScoreCreateRequest;
import com.mx.alternativecourses.api.application.controller.api.scores.detail.ScoreDetailResponse;
import com.mx.alternativecourses.api.application.controller.api.scores.update.ScoreUpdateRequest;
import com.mx.alternativecourses.api.application.controller.api.student.create.StudentCreateRequest;
import com.mx.alternativecourses.api.application.controller.api.student.detail.StudentResponse;
import com.mx.alternativecourses.api.application.controller.api.student.update.StudentUpdateRequest;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.use_case.score.create.ScoreCreateUseCase;
import com.mx.alternativecourses.api.domain.use_case.score.delete.ScoreDeleteUseCase;
import com.mx.alternativecourses.api.domain.use_case.score.detail.ScoreGetDetailUseCase;
import com.mx.alternativecourses.api.domain.use_case.score.list.ScoreSearchUseCase;
import com.mx.alternativecourses.api.domain.use_case.score.update.ScoreUpdateUseCase;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update.ScoreUpdateInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = GlobalConstants.SCORES, produces = MediaType.APPLICATION_JSON_VALUE)
public class ScoresApiController {

	private final ScoreCreateUseCase scoreCreateUseCase;
	private final ScoreUpdateUseCase scoreUpdateUseCase;
	private final ScoreGetDetailUseCase scoreGetDetailUseCase;
	private final ScoreSearchUseCase scoreSearchUseCase;
	private final ScoreDeleteUseCase scoreDeleteUseCase;
	private final Mapper<ScoreCreateRequest, ScoreCreateInput> scoreCreateRequestToScoreCreateInputMapper;
	private final Mapper<ScoreUpdateRequest, ScoreUpdateInput> scoreUpdateRequestToScoreUpdateInputMapper;
	private final Mapper<ScoreDomain, ScoreDetailResponse> scoreDomainToScoreDetailResponseMapper;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScoreDetailResponse> create(@Valid @RequestBody ScoreCreateRequest request) {
		return ResponseEntity.ok(
			this.scoreDomainToScoreDetailResponseMapper.map(
				this.scoreCreateUseCase.execute(this.scoreCreateRequestToScoreCreateInputMapper.map(request))
			)
		);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScoreDetailResponse> create(
		@PathVariable("id") Long studentId,
		@Valid @RequestBody ScoreUpdateRequest request
	) {
		return ResponseEntity.ok(
			this.scoreDomainToScoreDetailResponseMapper.map(
				this.scoreUpdateUseCase.execute(
					studentId,
					this.scoreUpdateRequestToScoreUpdateInputMapper.map(request)
				)
			)
		);
	}

	@GetMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScoreDetailResponse> detail(
		@PathVariable("id") Long studentId
	) {
		return ResponseEntity.ok(
			this.scoreDomainToScoreDetailResponseMapper.map(
				this.scoreGetDetailUseCase.execute(
					studentId
				)
			)
		);
	}

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScoreDetailResponse>> list() {
		List<ScoreDomain> list = this.scoreSearchUseCase.execute();

		return ResponseEntity.ok(
			list.stream().map(this.scoreDomainToScoreDetailResponseMapper::map).collect(Collectors.toList())
		);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		this.scoreDeleteUseCase.execute(id);
		return ResponseEntity.noContent().build();
	}
}
