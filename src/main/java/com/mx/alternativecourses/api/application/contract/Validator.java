package com.mx.alternativecourses.api.application.contract;

public interface Validator<T> {

	boolean isValid(T value);

}
