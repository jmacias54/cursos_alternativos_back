package com.mx.alternativecourses.api.application.beans;


import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.model.ScoreDomain;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.model.SubjectDomain;
import com.mx.alternativecourses.api.domain.model.UserDomain;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Score;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Subject;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.User;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.JpaScoreRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update.ScoreUpdateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.JpaStudentRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update.StudentUpdateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.JpaSubjectRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.user.JpaUserRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.user.UserCreateCreator;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.ScoreRepositoryJpa;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.StudentRepositoryJpa;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.SubjectRepositoryJpa;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.UserRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Repositories {


	@Bean
	public JpaScoreRepository jpaScoreRepository(
		ScoreRepositoryJpa scoreRepositoryJpa,
		SubjectRepositoryJpa subjectRepositoryJpa,
		StudentRepositoryJpa studentRepositoryJpa,
		ScoreCreateCreator scoreCreateCreator,
		ScoreUpdateCreator scoreUpdateCreator,
		Mapper<Score, ScoreDomain> scoreToScoreDomainMapper
	) {
		return new JpaScoreRepository(scoreRepositoryJpa,
			subjectRepositoryJpa,
			studentRepositoryJpa,
			scoreCreateCreator,
			scoreUpdateCreator,
			scoreToScoreDomainMapper);
	}

	@Bean
	public JpaSubjectRepository jpaSubjectRepository(
		SubjectRepositoryJpa subjectRepositoryJpa,
		Mapper<Subject, SubjectDomain> subjectToSubjectDomainMapper
	) {
		return new JpaSubjectRepository(subjectRepositoryJpa, subjectToSubjectDomainMapper);
	}

	@Bean
	public JpaStudentRepository jpaStudentRepository(
		StudentRepositoryJpa studentRepositoryJpa,
		Mapper<Student, StudentDomain> studentToStudentDomainMapper,
		StudentUpdateCreator studentUpdateCreator,
		StudentCreateCreator studentCreateCreator
	) {
		return new JpaStudentRepository(
			studentRepositoryJpa,
			studentToStudentDomainMapper,
			studentUpdateCreator,
			studentCreateCreator
		);
	}

	@Bean
	public JpaUserRepository jpaUserRepository(
		UserRepositoryJpa userRepositoryJpa,
		Mapper<User, UserDomain> userToUserDomainMapper,
		UserCreateCreator userCreateCreator
	) {
		return new JpaUserRepository(userRepositoryJpa, userToUserDomainMapper, userCreateCreator);
	}
}
