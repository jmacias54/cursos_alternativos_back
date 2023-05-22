package com.mx.alternativecourses.api.application.controller.api.student.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Optional;


@Data
@Accessors(chain = true)
@Schema(description = "Student Create Request")
public class StudentCreateRequest {

	@NotNull(message = "student.name.null")
	@Schema(description = "The name of Student.", example = "Virgilio")
	@JsonProperty("name")
	private final String name;

	@NotNull(message = "student.firstLastName.null")
	@Schema(description = "The first last name of Student.", example = "Lopez")
	@JsonProperty("firstLastName")
	private final String firstLastName;

	@Schema(description = "The second last name of Student.", example = "Diaz")
	@JsonProperty("secondLastName")
	private String secondLastName;

	@NotNull(message = "student.email.null")
	@Schema(description = "The email of Student.", example = "virgilio.lopez@gmail.com")
	@JsonProperty("email")
	private final String email;

	public Optional<String> getSecondLastName() {
		return Optional.ofNullable(this.secondLastName);
	}
}
