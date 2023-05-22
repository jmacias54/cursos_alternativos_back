package com.mx.alternativecourses.api.application.controller.api.student.detail;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@Accessors(chain = true)
@Schema(description = "Student Response")
public class StudentResponse {

	@Schema(description = "The identifier of Student.", example = "1234")
	@JsonProperty("id")
	private final Long id;

	@Schema(description = "The name of Student.", example = "Virgilio")
	@JsonProperty("name")
	private final String name;

	@Schema(description = "The first last name of Student.", example = "Lopez")
	@JsonProperty("firstLastName")
	private final String firstLastName;

	@Schema(description = "The second last name of Student.", example = "Diaz")
	@JsonProperty("secondLastName")
	private String secondLastName;

	@Schema(description = "The email of Student.", example = "virgilio.lopez@gmail.com")
	@JsonProperty("email")
	private final String email;

	public Optional<String> getSecondLastName() {
		return Optional.ofNullable(this.secondLastName);
	}

}
