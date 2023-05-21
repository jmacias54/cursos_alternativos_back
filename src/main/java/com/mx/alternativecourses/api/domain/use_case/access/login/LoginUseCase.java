package com.mx.alternativecourses.api.domain.use_case.access.login;

import com.mx.alternativecourses.api.domain.model.AuthenticationInfo;
import com.mx.alternativecourses.api.domain.model.LoginInfo;
import com.mx.alternativecourses.api.domain.services.security.UserAuthenticationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
public class LoginUseCase {

	private final UserAuthenticationManager authenticationManager;

	public LoginInfo execute(LoginInput input) {
		AuthenticationInfo authenticate = this.authenticationManager.authenticate(
			input.getUsername(),
			input.getPassword()
		);

		return new LoginInfo(authenticate);
	}

}
