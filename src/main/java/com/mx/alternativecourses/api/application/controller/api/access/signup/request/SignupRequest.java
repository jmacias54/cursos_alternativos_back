package com.mx.alternativecourses.api.application.controller.api.access.signup.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.alternativecourses.api.application.controller.validator.UsernameNotExist;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
@Schema(description = "Signup Request")
public class SignupRequest {

	@NotBlank(message = "signup.username.blank")
	@Size(min = 1, max = 100, message = "signup.username.size.invalid")
	@JsonProperty("username")
	@UsernameNotExist(message = "signup.username.exists")
	private final String username;

	@NotBlank(message = "signup.password.blank")
	@Size(min = 1, max = 100, message = "signup.password.size.invalid")
	@JsonProperty("password")
	private final String password;


}
