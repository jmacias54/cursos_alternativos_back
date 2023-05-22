package com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;


@Data
@Entity
@Table(name = "SUBJECTS", schema = "public")
@Accessors(chain = true)
public class Subject {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ENABLED")
	private boolean enabled = true;

	@Column(name = "DATE_CREATED")
	private Date dateCreated;

	@Column(name = "LAST_UPDATED")
	private Date lastUpdated;

	@Column(name = "DATE_DELETED")
	private Date dateDeleted = null;


	@PrePersist
	private void onCreate() {
		dateCreated = Timestamp.valueOf(LocalDateTime.now());
		lastUpdated = Timestamp.valueOf(LocalDateTime.now());
	}

	@PreUpdate
	private void onUpdate() {
		lastUpdated = Timestamp.valueOf(LocalDateTime.now());
	}

	public Optional<Date> getDateDeleted() {
		return Optional.ofNullable(this.dateDeleted);
	}
}
