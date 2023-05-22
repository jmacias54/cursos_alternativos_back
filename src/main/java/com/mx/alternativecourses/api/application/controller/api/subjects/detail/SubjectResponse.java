package com.mx.alternativecourses.api.application.controller.api.subjects.detail;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Subject Response")
public class SubjectResponse {

	@Schema(description = "The identifier of Subject.", example = "1234")
	@JsonProperty("id")
	private final Long id;

	@Schema(description = "The name of Subject.", example = "Chemistry")
	@JsonProperty("name")
	private final String name;
}
