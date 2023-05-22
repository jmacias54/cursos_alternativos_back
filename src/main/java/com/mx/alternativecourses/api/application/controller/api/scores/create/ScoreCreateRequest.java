package com.mx.alternativecourses.api.application.controller.api.scores.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;


@Data
@Schema(description = "Score Create Request")
public class ScoreCreateRequest {

	@NotNull(message = "score.studentId.null")
	@Schema(description = "The id of student.", example = "134")
	@JsonProperty("studentId")
	private final Long studentId;

	@NotNull(message = "score.subjectId.null")
	@Schema(description = "The id of subject.", example = "456")
	@JsonProperty("subjectId")
	private final Long subjectId;

	@NotNull(message = "score.score.null")
	@Schema(description = "Student grade.", example = "8.6")
	@JsonProperty("score")
	private final BigDecimal score;

	@NotNull(message = "score.registrationDate.null")
	@Schema(description = "Date of registration of score.", example = "2023/05/01")
	@JsonProperty("registrationDate")
	private final Date registrationDate;

}
