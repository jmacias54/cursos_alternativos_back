package com.mx.alternativecourses.api.application.controller.api.access.signup.request;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupInput;

public class SignupInputMapper implements Mapper<SignupRequest, SignupInput> {

	@Override
	public SignupInput map(SignupRequest request) {
		SignupInput signupInput = new SignupInput(
			request.getUsername(),
			request.getPassword()
		);

		return signupInput;
	}

}
