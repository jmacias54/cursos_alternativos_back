package com.mx.alternativecourses.api.domain.model;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ScoreDomain {

	private final Long id;
	private final BigDecimal score;
	private final Date registrationDate;
	private final Long studentId;
	private final Long subjectId;
	private final String subject;
}
