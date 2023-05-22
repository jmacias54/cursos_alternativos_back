package com.mx.alternativecourses.api.application.controller.api.student.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Optional;


@Data
@Accessors(chain = true)
@Schema(description = "Student Update Request")
public class StudentUpdateRequest {

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
