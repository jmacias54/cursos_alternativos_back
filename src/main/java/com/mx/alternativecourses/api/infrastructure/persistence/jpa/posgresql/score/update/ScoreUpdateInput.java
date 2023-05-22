package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;


@Data
@Accessors(chain = true)
public class ScoreUpdateInput {

	private Long studentId;
	private Long subjectId;
	private BigDecimal score;
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
