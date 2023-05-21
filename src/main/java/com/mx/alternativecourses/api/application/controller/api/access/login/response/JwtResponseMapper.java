package com.mx.alternativecourses.api.application.controller.api.access.login.response;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.application.configuration.properties.TokenProperties;
import com.mx.alternativecourses.api.domain.model.LoginInfo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtResponseMapper implements Mapper<LoginInfo, JwtResponse> {

	private static final String type = "Bearer";

	private final TokenProperties tokenProperties;

	@Override
	public JwtResponse map(LoginInfo info) {
		JwtResponse jwtResponse = new JwtResponse(
			info.getAuthenticationInfo().getToken(),
			null,
			type,
			this.tokenProperties.getJwtExpirationMs(),
			info.getAuthenticationInfo().getUserId(),
			info.getAuthenticationInfo().getUsername(),
			info.getAuthenticationInfo().getRoles()
		);

		return jwtResponse;
	}

}
