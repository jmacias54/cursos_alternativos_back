package com.mx.alternativecourses.api.domain.use_case.score.detail;

import com.mx.alternativecourses.api.domain.exception.BadRequestException;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.domain.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ScoreGetDetailUseCase {

	private final ScoreRepository scoreRepository;

	public ScoreDomain execute(Long id) {
		Optional<ScoreDomain> domain = this.scoreRepository.findById(id);

		if(domain.isPresent())
			throw new BadRequestException("score.exist");

		return domain.get();
	}
}
