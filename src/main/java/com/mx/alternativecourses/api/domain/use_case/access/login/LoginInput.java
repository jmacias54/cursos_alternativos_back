package com.mx.alternativecourses.api.domain.use_case.access.login;

import lombok.Data;

@Data
public class LoginInput {

	private final String username;
	private final String password;
}
