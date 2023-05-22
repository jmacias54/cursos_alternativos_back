package com.mx.alternativecourses.api.application.controller.api.student;


import com.mx.alternativecourses.api.application.configuration.constants.GlobalConstants;
import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.application.controller.api.student.create.StudentCreateRequest;
import com.mx.alternativecourses.api.application.controller.api.student.detail.StudentResponse;
import com.mx.alternativecourses.api.application.controller.api.student.detail.StudentScoresResponse;
import com.mx.alternativecourses.api.application.controller.api.student.update.StudentUpdateRequest;
import com.mx.alternativecourses.api.domain.model.StudentDomain;
import com.mx.alternativecourses.api.domain.model.StudentScoresDomain;
import com.mx.alternativecourses.api.domain.use_case.student.create.StudentCrateUseCase;
import com.mx.alternativecourses.api.domain.use_case.student.detail.StudentGetDetailUseCase;
import com.mx.alternativecourses.api.domain.use_case.student.list.StudentSearchUseCase;
import com.mx.alternativecourses.api.domain.use_case.student.update.StudentUpdateUseCase;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.create.StudentCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.student.update.StudentUpdateInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = GlobalConstants.STUDENTS, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentsApiController {

	private final StudentCrateUseCase studentCrateUseCase;
	private final StudentUpdateUseCase studentUpdateUseCase;
	private final StudentGetDetailUseCase studentGetDetailUseCase;
	private final StudentSearchUseCase studentSearchUseCase;
	private final Mapper<StudentUpdateRequest, StudentUpdateInput> studentUpdateRequestToStudentUpdateInputMapper;
	private final Mapper<StudentCreateRequest, StudentCreateInput> studentCreateRequestToStudentCreateInputMapper;
	private final Mapper<StudentDomain, StudentResponse> studentDomainToStudentResponseMapper;
	private final Mapper<StudentScoresDomain, StudentScoresResponse> studentScoresDomainToStudentScoresResponseMapper;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentCreateRequest request) {
		return ResponseEntity.ok(
			this.studentDomainToStudentResponseMapper.map(
				this.studentCrateUseCase.execute(this.studentCreateRequestToStudentCreateInputMapper.map(request))
			)
		);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> create(
		@PathVariable("id") Long studentId,
		@Valid @RequestBody StudentUpdateRequest request
	) {
		return ResponseEntity.ok(
			this.studentDomainToStudentResponseMapper.map(
				this.studentUpdateUseCase.execute(
					studentId,
					this.studentUpdateRequestToStudentUpdateInputMapper.map(request)
				)
			)
		);
	}

	@GetMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentScoresResponse> detail(
		@PathVariable("id") Long studentId
	) {
		return ResponseEntity.ok(
			this.studentScoresDomainToStudentScoresResponseMapper.map(
				this.studentGetDetailUseCase.execute(
					studentId
				)
			)
		);
	}

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentResponse>> list() {
		List<StudentDomain> list = this.studentSearchUseCase.execute();

		return ResponseEntity.ok(
			list.stream().map(this.studentDomainToStudentResponseMapper::map).collect(Collectors.toList())
		);
	}
}
