package com.mx.alternativecourses.api.application.controller.api.access.login.request;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.use_case.access.login.LoginInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginInputMapper implements Mapper<LoginRequest, LoginInput> {


	@Override
	public LoginInput map(LoginRequest input) {
		return new LoginInput(
			input.getUsername(),
			input.getPassword()
		);
	}

}
