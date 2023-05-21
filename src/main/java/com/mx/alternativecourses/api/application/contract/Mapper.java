package com.mx.alternativecourses.api.application.contract;

public interface Mapper<From, To> {

	To map(From input);

}


