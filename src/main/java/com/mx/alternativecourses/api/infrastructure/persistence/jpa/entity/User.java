package com.mx.alternativecourses.api.infrastructure.persistence.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER",schema = "public")
@Accessors(chain = true)
public class User {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Builder.Default
	@Column(name = "ENABLED")
	private boolean enabled = true;

	@Builder.Default
	@Column(name = "ACCOUNT_EXPIRED")
	private boolean accountExpired = false;

	@Builder.Default
	@Column(name = "ACCOUNT_LOCKED")
	private boolean accountLocked = false;

	@Builder.Default
	@Column(name = "PASSWORD_EXPIRED")
	private boolean passwordExpired = false;

	@Column(name = "DATE_CREATED")
	private Date dateCreated;

	@Builder.Default
	@Column(name = "DATE_DELETED")
	private Date dateDeleted = null;

	@Column(name = "LAST_UPDATED")
	private Date lastUpdated;


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
