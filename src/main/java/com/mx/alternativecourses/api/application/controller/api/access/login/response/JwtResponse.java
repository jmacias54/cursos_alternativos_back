package com.mx.alternativecourses.api.application.controller.api.access.login.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JwtResponse {

	@JsonProperty("access_token")
	private final String token;

	@JsonProperty("refresh_token")
	private final String tokenRefresh;

	@JsonProperty("token_type")
	private final String type;

	@JsonProperty("expires_in")
	private final Long expiresIn;

	@JsonProperty("id")
	private final Long id;

	@JsonProperty("username")
	private final String username;

	@JsonProperty("roles")
	private final List<String> roles;

	@JsonProperty("api_key")
	private String apikey;

	public Optional<String> getApikey() {
		return Optional.ofNullable(apikey);
	}

}
