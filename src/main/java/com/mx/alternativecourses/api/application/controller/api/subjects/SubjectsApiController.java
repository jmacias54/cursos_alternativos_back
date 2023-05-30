package com.mx.alternativecourses.api.application.controller.api.subjects;


import com.mx.alternativecourses.api.application.configuration.constants.GlobalConstants;
import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.application.controller.api.subjects.create.SubjectCreateRequest;
import com.mx.alternativecourses.api.application.controller.api.subjects.detail.SubjectResponse;
import com.mx.alternativecourses.api.application.controller.api.subjects.edit.SubjectUpdateRequest;
import com.mx.alternativecourses.api.domain.model.SubjectDomain;
import com.mx.alternativecourses.api.domain.use_case.subject.create.SubjectCrateUseCase;
import com.mx.alternativecourses.api.domain.use_case.subject.delete.SubjectDeleteUseCase;
import com.mx.alternativecourses.api.domain.use_case.subject.detail.SubjectGetDetailUseCase;
import com.mx.alternativecourses.api.domain.use_case.subject.edit.SubjectUpdateUseCase;
import com.mx.alternativecourses.api.domain.use_case.subject.list.SubjectSearchUseCase;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.create.SubjectCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.update.SubjectUpdateInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = GlobalConstants.SUBJECTS, produces = MediaType.APPLICATION_JSON_VALUE)
public class SubjectsApiController {

	private final SubjectDeleteUseCase subjectDeleteUseCase;
	private final SubjectUpdateUseCase subjectUpdateUseCase;
	private final SubjectCrateUseCase subjectCreateUseCase;
	private final SubjectGetDetailUseCase subjectGetDetailUseCase;
	private final SubjectSearchUseCase subjectSearchUseCase;
	private final Mapper<SubjectDomain, SubjectResponse> subjectDomainToSubjectResponseMapper;
	private final Mapper<SubjectCreateRequest, SubjectCreateInput> subjectCreateRequestToSubjectCreateInputMapper;
	private final Mapper<SubjectUpdateRequest, SubjectUpdateInput> subjectUpdateRequestToSubjectUpdateInputMapper;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubjectResponse> create(@Valid @RequestBody SubjectCreateRequest request) {
		return ResponseEntity.ok(
			this.subjectDomainToSubjectResponseMapper.map(
				this.subjectCreateUseCase.execute(this.subjectCreateRequestToSubjectCreateInputMapper.map(request))
			)
		);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubjectResponse> create(
		@PathVariable("id") Long studentId,
		@Valid @RequestBody SubjectUpdateRequest request
	) {
		return ResponseEntity.ok(
			this.subjectDomainToSubjectResponseMapper.map(
				this.subjectUpdateUseCase.execute(
					studentId,
					this.subjectUpdateRequestToSubjectUpdateInputMapper.map(request)
				)
			)
		);
	}

	@GetMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubjectResponse> detail(
		@PathVariable("id") Long studentId
	) {
		return ResponseEntity.ok(
			this.subjectDomainToSubjectResponseMapper.map(
				this.subjectGetDetailUseCase.execute(
					studentId
				)
			)
		);
	}

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubjectResponse>> list() {
		List<SubjectDomain> list = this.subjectSearchUseCase.execute();

		return ResponseEntity.ok(
			list.stream().map(this.subjectDomainToSubjectResponseMapper::map).collect(Collectors.toList())
		);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		this.subjectDeleteUseCase.execute(id);

		return ResponseEntity.noContent().build();
	}
}
