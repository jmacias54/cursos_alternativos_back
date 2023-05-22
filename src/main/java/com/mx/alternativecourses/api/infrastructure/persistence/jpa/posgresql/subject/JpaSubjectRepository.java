package com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject;

import com.mx.alternativecourses.api.application.contract.Mapper;
import com.mx.alternativecourses.api.domain.exception.ItemNotFoundException;
import com.mx.alternativecourses.api.domain.model.SubjectDomain;
import com.mx.alternativecourses.api.domain.repository.SubjectRepository;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity.Subject;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.create.SubjectCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.update.SubjectUpdateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.repository.SubjectRepositoryJpa;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaSubjectRepository implements SubjectRepository {

	private final SubjectRepositoryJpa subjectRepositoryJpa;
	private final Mapper<Subject, SubjectDomain> subjectToSubjectDomainMapper;

	@Override
	public SubjectDomain create(SubjectCreateInput input) {
		Subject subject = this.subjectRepositoryJpa.save(new Subject().setName(input.getName()));
		return this.subjectToSubjectDomainMapper.map(subject);
	}

	@Override
	public SubjectDomain update(Long id, SubjectUpdateInput input) {
		Optional<Subject> subjectOptional = this.subjectRepositoryJpa.findById(id);

		if(subjectOptional.isEmpty()) {
			new ItemNotFoundException("subject.notFound");
		}

		Subject subject = this.subjectRepositoryJpa.save(subjectOptional.get().setName(input.getName()));
		return this.subjectToSubjectDomainMapper.map(subject);
	}

	@Override
	public void delete(Long id) {
		Optional<Subject> subject = this.subjectRepositoryJpa.findById(id);

		if(subject.isPresent())
			this.subjectRepositoryJpa.delete(subject.get());

	}

	@Override
	public Optional<SubjectDomain> find(Long id) {
		return this.subjectRepositoryJpa.findById(id).map(this.subjectToSubjectDomainMapper::map);
	}

	@Override
	public Optional<SubjectDomain> findByName(String name) {
		return this.subjectRepositoryJpa.findByNameAndDateDeletedIsNull(name).map(this.subjectToSubjectDomainMapper::map);
	}


	@Override
	public List<SubjectDomain> findAll() {
		return this.subjectRepositoryJpa.findAll().stream()
			.map(this.subjectToSubjectDomainMapper::map)
			.collect(Collectors.toList());
	}
}
