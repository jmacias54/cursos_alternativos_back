package com.mx.alternativecourses.api.domain.repository;

import com.mx.alternativecourses.api.domain.model.SubjectDomain;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.create.SubjectCreateInput;
import com.mx.alternativecourses.api.infrastructure.persistence.jpa.posgresql.subject.update.SubjectUpdateInput;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository {

	SubjectDomain create(SubjectCreateInput input);

	SubjectDomain update(Long id, SubjectUpdateInput input);

	void delete(Long id);

	List<SubjectDomain> findAll();

	Optional<SubjectDomain> find(Long id);

	Optional<SubjectDomain> findByName(String name);

}
