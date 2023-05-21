package com.mx.alternativecourses.api.domain.model;


import lombok.Data;

@Data
public class UserDomain {

	private final Long id;
	private final String name;
	private final String password;
}
