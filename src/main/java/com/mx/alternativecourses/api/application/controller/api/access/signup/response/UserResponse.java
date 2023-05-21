package com.mx.alternativecourses.api.application.controller.api.access.signup.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserResponse {

	@JsonProperty("id")
	private final Long id;

	@JsonProperty("username")
	private final String username;


}
