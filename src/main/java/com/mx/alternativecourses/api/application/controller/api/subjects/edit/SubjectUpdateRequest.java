package com.mx.alternativecourses.api.application.controller.api.subjects.edit;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Subject Update Request")
public class SubjectUpdateRequest {

	@Schema(description = "The name of Subject.", example = "Chemistry")
	@JsonProperty("name")
	private final String name;

}
