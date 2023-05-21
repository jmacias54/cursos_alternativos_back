package com.mx.alternativecourses.api.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@Accessors(chain = true)
public class LoginInfo {

	private final AuthenticationInfo authenticationInfo;


}
