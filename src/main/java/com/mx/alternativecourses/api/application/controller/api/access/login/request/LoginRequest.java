package com.mx.alternativecourses.api.application.controller.api.access.login.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginRequest {

	@NotBlank(message = "login.username.blank")
	@Size(min = 1, max = 100, message = "login.username.size")
	@JsonProperty("username")
	private final String username;

	@NotBlank(message = "login.password.blank")
	@Size(min = 1, max = 100, message = "login.password.size")
	@JsonProperty("password")
	private final String password;

}
