package com.mx.alternativecourses.api.application.controller.validator;

import com.mx.alternativecourses.api.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UsernameNotExistValidator implements ConstraintValidator<UsernameNotExist, String> {

	private final UserRepository userRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return this.userRepository.find(value).isEmpty();
	}

}
