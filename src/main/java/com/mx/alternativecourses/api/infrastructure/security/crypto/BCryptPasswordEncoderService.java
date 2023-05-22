package com.mx.alternativecourses.api.infrastructure.security.crypto;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class BCryptPasswordEncoderService implements PasswordEncoder {

	private final PasswordEncoder delegate;

	@Override
	public String encode(CharSequence rawPassword) {
		return delegate.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return delegate.matches(rawPassword, encodedPassword);
	}

}
