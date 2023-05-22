package com.mx.alternativecourses.api.domain.use_case.student.detail;


import com.mx.alternativecourses.api.domain.exception.ItemNotFoundException;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.model.StudentScoresDomain;
import com.mx.alternativecourses.api.domain.repository.ScoreRepository;
import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class StudentGetDetailUseCase {

	private final StudentRepository studentRepository;
	private final ScoreRepository scoreRepository;


	public StudentScoresDomain execute(Long id) {
		BigDecimal average = BigDecimal.ZERO;
		Optional<StudentDomain> student = this.studentRepository.find(id);

		if(student.isEmpty()) {
			throw new ItemNotFoundException("student.notFound");
		}

		List<ScoreDomain> scoresList = this.scoreRepository.findByStudentId(id);

		if(!scoresList.isEmpty())
			average = scoresList.stream()
				.map(score -> score.getScore())
				.reduce(BigDecimal.ZERO, BigDecimal::add)
				.divide(BigDecimal.valueOf(scoresList.size()), 2, BigDecimal.ROUND_HALF_UP);


		return new StudentScoresDomain(student.get(), scoresList, average);
	}

}
