package com.mx.alternativecourses.api.application.beans;


import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import com.mx.alternativecourses.api.domain.repository.SubjectRepository;
import com.mx.alternativecourses.api.domain.repository.UserRepository;
import com.mx.alternativecourses.api.domain.services.security.UserAuthenticationManager;
import com.mx.alternativecourses.api.domain.use_case.access.login.LoginUseCase;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupUseCase;
import com.mx.alternativecourses.api.domain.use_case.access.subject.create.SubjectCrateUseCase;
import com.mx.alternativecourses.api.domain.use_case.access.subject.delete.SubjectDeleteUseCase;
import com.mx.alternativecourses.api.domain.use_case.access.subject.detail.SubjectGetDetailUseCase;
import com.mx.alternativecourses.api.domain.use_case.access.subject.edit.SubjectUpdateUseCase;
import com.mx.alternativecourses.api.domain.use_case.access.subject.list.SubjectSearchUseCase;
import com.mx.alternativecourses.api.domain.use_case.student.create.StudentCrateUseCase;
import com.mx.alternativecourses.api.domain.use_case.student.detail.StudentGetDetailUseCase;
import com.mx.alternativecourses.api.domain.use_case.student.list.StudentSearchUseCase;
import com.mx.alternativecourses.api.domain.use_case.student.update.StudentUpdateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UseCase {


	@Bean
	public SubjectDeleteUseCase subjectDeleteUseCase(SubjectRepository subjectRepository) {
		return new SubjectDeleteUseCase(subjectRepository);
	}

	@Bean
	public SubjectUpdateUseCase subjectUpdateUseCase(SubjectRepository subjectRepository) {
		return new SubjectUpdateUseCase(subjectRepository);
	}

	@Bean
	public SubjectCrateUseCase subjectCreateUseCase(SubjectRepository subjectRepository) {
		return new SubjectCrateUseCase(subjectRepository);
	}

	@Bean
	public SubjectGetDetailUseCase subjectGetDetailUseCase(SubjectRepository subjectRepository) {
		return new SubjectGetDetailUseCase(subjectRepository);
	}

	@Bean
	public SubjectSearchUseCase subjectSearchUseCase(SubjectRepository subjectRepository) {
		return new SubjectSearchUseCase(subjectRepository);
	}

	@Bean
	public StudentCrateUseCase studentCrateUseCase(StudentRepository studentRepository) {
		return new StudentCrateUseCase(studentRepository);
	}

	@Bean
	public StudentUpdateUseCase studentUpdateUseCase(StudentRepository studentRepository) {
		return new StudentUpdateUseCase(studentRepository);
	}

	@Bean
	public StudentGetDetailUseCase studentGetDetailUseCase(StudentRepository studentRepository) {
		return new StudentGetDetailUseCase(studentRepository);
	}

	@Bean
	public StudentSearchUseCase studentSearchUseCase(StudentRepository studentRepository) {
		return new StudentSearchUseCase(studentRepository);
	}


	@Bean
	public LoginUseCase loginUseCase(UserAuthenticationManager authenticationManager) {
		return new LoginUseCase(authenticationManager);
	}

	@Bean
	public SignupUseCase signupUseCase(
		UserRepository userRepository, PasswordEncoder passwordEncoder
	) {
		return new SignupUseCase(userRepository, passwordEncoder);
	}

}
