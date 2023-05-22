package com.mx.alternativecourses.api.application.controller.api.scores.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;


@Data
@Accessors(chain = true)
@Schema(description = "Score Update Request")
public class ScoreUpdateRequest {

	@Schema(description = "The id of student.", example = "134")
	@JsonProperty("studentId")
	private Long studentId;

	@Schema(description = "The id of subject.", example = "456")
	@JsonProperty("subjectId")
	private Long subjectId;

	@Schema(description = "Student grade.", example = "8.6")
	@JsonProperty("score")
	private BigDecimal score;

	@Schema(description = "Date of registration of score.", example = "2023/05/01")
	@JsonProperty("registrationDate")
	private Date registrationDate;

	public Optional<Long> getStudentId() {
		return Optional.ofNullable(this.studentId);
	}

	public Optional<BigDecimal> getScore() {
		return Optional.ofNullable(this.score);
	}

	public Optional<Long> getSubjectId() {
		return Optional.ofNullable(this.subjectId);
	}

	public Optional<Date> getRegistrationDate() {
		return Optional.ofNullable(this.registrationDate);
	}

}
