package com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository;


import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Score;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScoreRepositoryJpa extends JpaRepository<Score,Long> {

	Optional<Score> findByStudent_IdAndSubject_IdAndDateDeletedIsNull(
		Long studentId,
		Long subjectId
	);

	List<Score> findByStudent_IdAndDateDeletedIsNull(Long studentId);
}
