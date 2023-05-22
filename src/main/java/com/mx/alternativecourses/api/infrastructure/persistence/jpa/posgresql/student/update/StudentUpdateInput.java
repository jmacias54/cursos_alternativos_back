package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@Accessors(chain = true)
public class StudentUpdateInput {
	private String name;
	private String firstLastName;
	private String secondLastName;
	private String email;

	public Optional<String> getSecondLastName() {
		return Optional.ofNullable(this.secondLastName);
	}

	public Optional<String> getName() {
		return Optional.ofNullable(this.name);
	}

	public Optional<String> getFirstLastName() {
		return Optional.ofNullable(this.firstLastName);
	}

	public Optional<String> getEmail() {
		return Optional.ofNullable(this.email);
	}

}
