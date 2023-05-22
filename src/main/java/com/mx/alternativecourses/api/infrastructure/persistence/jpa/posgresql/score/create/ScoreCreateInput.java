package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class ScoreCreateInput {

	private final Long studentId;
	private final Long subjectId;
	private final BigDecimal score;
	private final Date registrationDate;

}
