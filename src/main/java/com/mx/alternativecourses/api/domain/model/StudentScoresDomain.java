package com.mx.alternativecourses.api.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class StudentScoresDomain {

	private final StudentDomain student;
	private final List<ScoreDomain> scores;
	private final BigDecimal average;
}
