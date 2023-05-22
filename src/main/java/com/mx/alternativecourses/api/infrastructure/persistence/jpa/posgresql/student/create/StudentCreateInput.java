package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@Accessors(chain = true)
public class StudentCreateInput {

	private final String name;
	private final String firstLastName;
	private String secondLastName;
	private final String email;

	public Optional<String> getSecondLastName() {
		return Optional.ofNullable(this.secondLastName);
	}

}
