package com.mx.alternativecourses.api.domain.use_case.access.signup;

import com.mx.alternativecourses.api.domain.model.UserDomain;
import com.mx.alternativecourses.api.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
public class SignupUseCase {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public SignupInfo execute(SignupInput input) {
		UserDomain userDomain = this.userRepository.create(
			input.getUsername(),
			passwordEncoder.encode(input.getPassword())
		);

		return new SignupInfo(
			userDomain
		);
	}

}
