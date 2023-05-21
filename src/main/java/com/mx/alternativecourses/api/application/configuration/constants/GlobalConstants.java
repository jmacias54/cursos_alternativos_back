package com.mx.alternativecourses.api.application.configuration.constants;

public class GlobalConstants {

	public static final String LOGIN = "/login";
	public static final String SIGNUP = "/signup";
	public static final String ACCESS_TOKEN = "/oauth/access_token";

	public static final String SCORES = "/scores";
	public static final String STUDENTS = "/students";
	public static final String SUBJECTS = "/subjects";



	public static final String[] ANT_MATCHERS_PERMIT_ALL = new String[]{
		ACCESS_TOKEN,
		SIGNUP,
		LOGIN,
		"/swagger-ui/**",
		"/swagger-ui.html",
		"/v3/api-docs/**",
		"/actuator/health"
	};
}
