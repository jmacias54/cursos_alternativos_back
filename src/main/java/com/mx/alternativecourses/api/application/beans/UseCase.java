package com.mx.alternativecourses.api.application.beans;


import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import com.mx.alternativecourses.api.domain.repository.UserRepository;
import com.mx.alternativecourses.api.domain.services.security.UserAuthenticationManager;
import com.mx.alternativecourses.api.domain.use_case.access.login.LoginUseCase;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupUseCase;
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
