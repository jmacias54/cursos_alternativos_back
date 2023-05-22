package com.mx.alternativecourses.api.application.controller.api.student.detail;

import com.mx.alternativecourses.api.application.controller.api.scores.detail.ScoreDetailResponse;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class StudentScoresResponse {

	private final StudentResponse student;
	private final List<ScoreDetailResponse> scores;
	private final BigDecimal average;
}
