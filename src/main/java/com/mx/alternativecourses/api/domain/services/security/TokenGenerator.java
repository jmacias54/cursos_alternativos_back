package com.mx.alternativecourses.api.domain.services.security;

import org.springframework.security.core.Authentication;

public interface TokenGenerator {

	String generateJwtToken(Authentication authentication);

	String generateTokenFromUsername(String username);

	String getUserNameFromJwtToken(String token);

	boolean validateJwtToken(String authToken);

}
