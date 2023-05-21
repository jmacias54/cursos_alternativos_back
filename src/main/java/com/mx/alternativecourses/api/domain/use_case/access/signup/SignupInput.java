package com.mx.alternativecourses.api.domain.use_case.access.signup;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SignupInput {

	private final String username;
	private final String password;
}
