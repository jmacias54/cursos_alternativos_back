package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update;

import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Score;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Subject;

import java.util.Optional;

public class ScoreUpdateCreator {
	public Score create(ScoreUpdateInput input, Optional<Student> student, Optional<Subject> subject, Score score) {

		student.ifPresent(score::setStudent);
		subject.ifPresent(score::setSubject);
		input.getScore().ifPresent(score::setScore);
		input.getRegistrationDate().ifPresent(score::setDateCreated);
		return score;
	}
}
