package com.mx.alternativecourses.api.application.controller.api.scores.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Schema(description = "Score Detail Response")
public class ScoreDetailResponse {

	@Schema(description = "The identification of score.", example = "134")
	@JsonProperty("id")
	private final Long id;

	@Schema(description = "The id of student.", example = "134")
	@JsonProperty("studentId")
	private final Long studentId;

	@Schema(description = "The id of subject.", example = "456")
	@JsonProperty("subjectId")
	private final Long subjectId;

	@Schema(description = "Student grade.", example = "8.6")
	@JsonProperty("score")
	private final BigDecimal score;

	@Schema(description = "Date of registration of score.", example = "2023/05/01")
	@JsonProperty("registrationDate")
	private final Date registrationDate;

}
