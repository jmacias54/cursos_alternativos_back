package com.mx.alternativecourses.api.domain.use_case.score.list;

import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.domain.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ScoreSearchUseCase {

	private final ScoreRepository scoreRepository;

	public List<ScoreDomain> execute() {
		return this.scoreRepository.findAll();
	}
}
