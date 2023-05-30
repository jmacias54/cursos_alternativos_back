package com.mx.alternativecourses.api.application.controller.api.access;


import com.mx.alternativecourses.api.application.configuration.constants.GlobalConstants;
import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.application.controller.api.access.login.request.LoginRequest;
import com.mx.alternativecourses.api.application.controller.api.access.login.response.JwtResponse;
import com.mx.alternativecourses.api.application.controller.api.access.signup.request.SignupRequest;
import com.mx.alternativecourses.api.application.controller.api.access.signup.response.UserResponse;
import com.mx.alternativecourses.api.domain.model.LoginInfo;
import com.mx.alternativecourses.api.domain.use_case.access.login.LoginInput;
import com.mx.alternativecourses.api.domain.use_case.access.login.LoginUseCase;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupInfo;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupInput;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AccessApiController {

	private final LoginUseCase loginUseCase;
	private final SignupUseCase signupUseCase;
	private final Mapper<SignupInfo, UserResponse> userResponseMapper;
	private final Mapper<SignupRequest, SignupInput> signupInputMapper;
	private final Mapper<LoginRequest, LoginInput> loginInputMapper;
	private final Mapper<LoginInfo, JwtResponse> jwtResponseMapper;

	@PostMapping(value = GlobalConstants.SIGNUP, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> signup(@Valid @RequestBody SignupRequest request) {
		return ResponseEntity.ok(
			this.userResponseMapper.map(
				this.signupUseCase.execute(this.signupInputMapper.map(request))
			)
		);
	}

	@PostMapping(value = GlobalConstants.LOGIN, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JwtResponse> authenticate(@Valid @RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(
			this.jwtResponseMapper.map(
				this.loginUseCase.execute(this.loginInputMapper.map(loginRequest))
			)
		);
	}

}
