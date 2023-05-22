package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.create;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class SubjectCreateInput {
	private final String name;
}
