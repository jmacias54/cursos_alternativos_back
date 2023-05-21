package com.mx.alternativecourses.api.application.controller.api.access.signup.response;


import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupInfo;

public class UserResponseMapper implements Mapper<SignupInfo, UserResponse> {

	@Override
	public UserResponse map(SignupInfo info) {
		return new UserResponse(
			info.getUserDomain().getId(),
			info.getUserDomain().getName()
		);
	}

}
