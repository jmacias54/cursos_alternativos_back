package com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Data
@Entity
@Table(name = "STUDENT", schema = "public")
@Accessors(chain = true)
public class Student {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "FIRST_LAST_NAME")
	private String firstLastName;

	@Column(name = "SECOND_LAST_NAME")
	private String secondLastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DATE_CREATED")
	@CreationTimestamp
	private Date dateCreated;

	@Column(name = "LAST_UPDATED")
	@CreationTimestamp
	private Date lastUpdated;

	@Column(name = "DATE_DELETED")
	private Date dateDeleted;

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

	public Optional<String> getSecondLastName() {
		return Optional.ofNullable(this.secondLastName);
	}

}
