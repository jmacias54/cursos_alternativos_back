package com.mx.alternativecourses.api.application.controller.api.student.detail;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.application.controller.api.scores.detail.ScoreDetailResponse;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.model.StudentScoresDomain;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class StudentScoresDomainToStudentScoresResponseMapper implements Mapper<StudentScoresDomain, StudentScoresResponse> {

	private final Mapper<StudentDomain, StudentResponse> studentDomainToStudentResponseMapper;
	private final Mapper<ScoreDomain, ScoreDetailResponse> scoreDomainToScoreDetailResponseMapper;

	@Override
	public StudentScoresResponse map(StudentScoresDomain input) {
		return new StudentScoresResponse(
			this.studentDomainToStudentResponseMapper.map(
				input.getStudent()),
				input.getScores()
					.stream()
					.map(this.scoreDomainToScoreDetailResponseMapper::map)
					.collect(Collectors.toList()),
				input.getAverage()
		);
	}
}
