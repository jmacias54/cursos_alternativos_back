package com.mx.alternativecourses.api.domain.model;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@Accessors(chain = true)
public class StudentDomain {

	private final Long id;
	private final String name;
	private final String firstLastName;
	private  String secondLastName;
	private final String email;

	public Optional<String> getSecondLastName() {
		return Optional.ofNullable(this.secondLastName);
	}


}
