package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create;

import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Score;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Subject;

public class ScoreCreateCreator {

	public Score create(ScoreCreateInput input, Student student, Subject subject) {
		return new Score()
			.setScore(input.getScore())
			.setStudent(student)
			.setSubject(subject)
			.setRegistrationDate(input.getRegistrationDate());

	}
}
