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
import com.mx.alternativecourses.api.application.controller.api.student.create.StudentCreateRequest;
import com.mx.alternativecourses.api.application.controller.api.student.create.StudentCreateRequestToStudentCreateInputMapper;
import com.mx.alternativecourses.api.application.controller.api.student.detail.StudentDomainToStudentResponseMapper;
import com.mx.alternativecourses.api.application.controller.api.student.detail.StudentResponse;
import com.mx.alternativecourses.api.application.controller.api.student.update.StudentUpdateRequest;
import com.mx.alternativecourses.api.application.controller.api.student.update.StudentUpdateRequestToStudentUpdateInputMapper;
import com.mx.alternativecourses.api.domain.model.LoginInfo;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.model.UserDomain;
import com.mx.alternativecourses.api.domain.use_case.access.login.LoginInput;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupInfo;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Student;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.User;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.StudentToStudentDomainMapper;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update.StudentUpdateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.user.UserToUserDomainMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mappers {

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
