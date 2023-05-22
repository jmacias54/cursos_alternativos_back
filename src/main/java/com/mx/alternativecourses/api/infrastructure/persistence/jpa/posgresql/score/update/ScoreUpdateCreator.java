package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update;

import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Score;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Subject;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateInput;

public class ScoreUpdateCreator {
	public Score create(ScoreCreateInput input, Student student, Subject subject) {
		return new Score()
			.setScore(input.getScore())
			.setStudent(student)
			.setSubject(subject)
			.setRegistrationDate(input.getRegistrationDate());

	}
}
