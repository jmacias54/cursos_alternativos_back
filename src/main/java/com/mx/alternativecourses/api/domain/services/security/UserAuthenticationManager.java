package com.mx.alternativecourses.api.domain.services.security;

import com.mx.alternativecourses.api.domain.model.AuthenticationInfo;

public interface UserAuthenticationManager {

	AuthenticationInfo authenticate(String username, String password);

}
