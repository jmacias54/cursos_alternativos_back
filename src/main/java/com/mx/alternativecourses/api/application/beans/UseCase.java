package com.mx.alternativecourses.api.application.beans;


import com.mx.alternativecourses.api.domain.repository.UserRepository;
import com.mx.alternativecourses.api.domain.services.security.UserAuthenticationManager;
import com.mx.alternativecourses.api.domain.use_case.access.login.LoginUseCase;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UseCase {

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
