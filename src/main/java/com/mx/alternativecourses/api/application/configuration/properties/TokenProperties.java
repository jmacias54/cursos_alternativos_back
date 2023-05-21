package com.mx.alternativecourses.api.application.configuration.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Accessors(chain = true)
@Configuration
public class TokenProperties {

	@Value("${jwtSecret}")
	private String jwtSecret;

	@Value("${jwtExpirationMs}")
	private Long jwtExpirationMs;

	@Value("${jwtRefreshExpirationMs}")
	private Long refreshTokenDurationMs;

}