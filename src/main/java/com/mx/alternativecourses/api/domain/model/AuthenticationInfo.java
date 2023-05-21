package com.mx.alternativecourses.api.domain.model;

import lombok.Data;

import java.util.List;


@Data
public class AuthenticationInfo {

	private final Long userId;
	private final String username;
	private final List<String> roles;
	private final String token;

}
