package com.mx.alternativecourses.api.application.beans;


import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.application.controller.api.access.login.request.LoginInputMapper;
import com.mx.alternativecourses.api.application.controller.api.access.login.request.LoginRequest;
import com.mx.alternativecourses.api.application.controller.api.access.login.response.JwtResponse;
import com.mx.alternativecourses.api.application.controller.api.access.login.response.JwtResponseMapper;
import com.mx.alternativecourses.api.application.controller.api.access.signup.request.SignupInputMapper;
import com.mx.alternativecourses.api.application.controller.api.access.signup.request.SignupRequest;
import com.mx.alternativecourses.api.application.controller.api.access.signup.response.UserResponse;
import com.mx.alternativecourses.api.application.controller.api.access.signup.response.UserResponseMapper;
import com.mx.alternativecourses.api.application.configuration.properties.TokenProperties;
import com.mx.alternativecourses.api.application.controller.api.scores.create.ScoreCreateRequest;
import com.mx.alternativecourses.api.application.controller.api.scores.create.ScoreCreateRequestToScoreCreateInputMapper;
import com.mx.alternativecourses.api.application.controller.api.scores.detail.ScoreDetailResponse;
import com.mx.alternativecourses.api.application.controller.api.scores.detail.ScoreDomainToScoreDetailResponseMapper;
import com.mx.alternativecourses.api.application.controller.api.scores.update.ScoreUpdateRequest;
import com.mx.alternativecourses.api.application.controller.api.scores.update.ScoreUpdateRequestToScoreUpdateInputMapper;
import com.mx.alternativecourses.api.application.controller.api.student.create.StudentCreateRequest;
import com.mx.alternativecourses.api.application.controller.api.student.create.StudentCreateRequestToStudentCreateInputMapper;
import com.mx.alternativecourses.api.application.controller.api.student.detail.StudentDomainToStudentResponseMapper;
import com.mx.alternativecourses.api.application.controller.api.student.detail.StudentResponse;
import com.mx.alternativecourses.api.application.controller.api.student.update.StudentUpdateRequest;
import com.mx.alternativecourses.api.application.controller.api.student.update.StudentUpdateRequestToStudentUpdateInputMapper;
import com.mx.alternativecourses.api.application.controller.api.subjects.create.SubjectCreateRequest;
import com.mx.alternativecourses.api.application.controller.api.subjects.create.SubjectCreateRequestToSubjectCreateInputMapper;
import com.mx.alternativecourses.api.application.controller.api.subjects.detail.SubjectDomainToSubjectResponseMapper;
import com.mx.alternativecourses.api.application.controller.api.subjects.detail.SubjectResponse;
import com.mx.alternativecourses.api.application.controller.api.subjects.edit.SubjectUpdateRequest;
import com.mx.alternativecourses.api.application.controller.api.subjects.edit.SubjectUpdateRequestToSubjectUpdateInputMapper;
import com.mx.alternativecourses.api.domain.model.*;
import com.mx.alternativecourses.api.domain.use_case.access.login.LoginInput;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupInfo;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Score;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Subject;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.User;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.ScoreToScoreDomainMapper;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.create.ScoreCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.score.update.ScoreUpdateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.StudentToStudentDomainMapper;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update.StudentUpdateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.SubjectToSubjectDomainMapper;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.create.SubjectCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.update.SubjectUpdateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.user.UserToUserDomainMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mappers {


	@Bean
	public Mapper<Score, ScoreDomain> scoreToScoreDomainMapper() {
		return new ScoreToScoreDomainMapper();
	}

	@Bean
	public Mapper<ScoreCreateRequest, ScoreCreateInput> scoreCreateRequestToScoreCreateInputMapper() {
		return new ScoreCreateRequestToScoreCreateInputMapper();
	}

	@Bean
	public Mapper<ScoreUpdateRequest, ScoreUpdateInput> scoreUpdateRequestToScoreUpdateInputMapper() {
		return new ScoreUpdateRequestToScoreUpdateInputMapper();
	}

	@Bean
	public Mapper<ScoreDomain, ScoreDetailResponse> scoreDomainToScoreDetailResponseMapper() {
		return new ScoreDomainToScoreDetailResponseMapper();
	}

	@Bean
	public Mapper<SubjectDomain, SubjectResponse> subjectDomainToSubjectResponseMapper() {
		return new SubjectDomainToSubjectResponseMapper();
	}

	@Bean
	public Mapper<SubjectCreateRequest, SubjectCreateInput> subjectCreateRequestToSubjectCreateInputMapper() {
		return new SubjectCreateRequestToSubjectCreateInputMapper();
	}

	@Bean
	public Mapper<SubjectUpdateRequest, SubjectUpdateInput> subjectUpdateRequestToSubjectUpdateInputMapper() {
		return new SubjectUpdateRequestToSubjectUpdateInputMapper();
	}

	@Bean
	public Mapper<Subject, SubjectDomain> subjectToSubjectDomainMapper() {
		return new SubjectToSubjectDomainMapper();
	}

	@Bean
	public Mapper<StudentUpdateRequest, StudentUpdateInput> studentUpdateRequestToStudentUpdateInputMapper() {
		return new StudentUpdateRequestToStudentUpdateInputMapper();
	}

	@Bean
	public Mapper<StudentCreateRequest, StudentCreateInput> studentCreateRequestToStudentCreateInputMapper() {
		return new StudentCreateRequestToStudentCreateInputMapper();
	}

	@Bean
	public Mapper<StudentDomain, StudentResponse> studentDomainToStudentResponseMapper() {
		return new StudentDomainToStudentResponseMapper();
	}

	@Bean
	public Mapper<Student, StudentDomain> studentToStudentDomainMapper() {
		return new StudentToStudentDomainMapper();
	}

	@Bean
	public Mapper<User, UserDomain> userToUserDomainMapper() {
		return new UserToUserDomainMapper();
	}

	@Bean
	public Mapper<SignupRequest, SignupInput> signupInputMapper() {
		return new SignupInputMapper();
	}

	@Bean
	public Mapper<SignupInfo, UserResponse> userResponseMapper() {
		return new UserResponseMapper();
	}

	@Bean
	public Mapper<LoginRequest, LoginInput> loginInputMapper() {
		return new LoginInputMapper();
	}

	@Bean
	public Mapper<LoginInfo, JwtResponse> jwtResponseMapper(TokenProperties tokenProperties) {
		return new JwtResponseMapper(tokenProperties);
	}


}
