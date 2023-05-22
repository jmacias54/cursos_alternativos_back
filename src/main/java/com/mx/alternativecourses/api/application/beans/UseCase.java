package com.mx.alternativecourses.api.application.beans;


import com.mx.alternativecourses.api.domain.repository.ScoreRepository;
import com.mx.alternativecourses.api.domain.repository.StudentRepository;
import com.mx.alternativecourses.api.domain.repository.SubjectRepository;
import com.mx.alternativecourses.api.domain.repository.UserRepository;
import com.mx.alternativecourses.api.domain.services.security.UserAuthenticationManager;
import com.mx.alternativecourses.api.domain.use_case.access.login.LoginUseCase;
import com.mx.alternativecourses.api.domain.use_case.access.signup.SignupUseCase;
import com.mx.alternativecourses.api.domain.use_case.score.create.ScoreCreateUseCase;
import com.mx.alternativecourses.api.domain.use_case.score.delete.ScoreDeleteUseCase;
import com.mx.alternativecourses.api.domain.use_case.score.detail.ScoreGetDetailUseCase;
import com.mx.alternativecourses.api.domain.use_case.score.list.ScoreSearchUseCase;
import com.mx.alternativecourses.api.domain.use_case.score.update.ScoreUpdateUseCase;
import com.mx.alternativecourses.api.domain.use_case.student.create.StudentCrateUseCase;
import com.mx.alternativecourses.api.domain.use_case.student.detail.StudentGetDetailUseCase;
import com.mx.alternativecourses.api.domain.use_case.student.list.StudentSearchUseCase;
import com.mx.alternativecourses.api.domain.use_case.student.update.StudentUpdateUseCase;
import com.mx.alternativecourses.api.domain.use_case.subject.create.SubjectCrateUseCase;
import com.mx.alternativecourses.api.domain.use_case.subject.delete.SubjectDeleteUseCase;
import com.mx.alternativecourses.api.domain.use_case.subject.detail.SubjectGetDetailUseCase;
import com.mx.alternativecourses.api.domain.use_case.subject.edit.SubjectUpdateUseCase;
import com.mx.alternativecourses.api.domain.use_case.subject.list.SubjectSearchUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UseCase {


	@Bean
	public ScoreGetDetailUseCase scoreGetDetailUseCase(ScoreRepository scoreRepository) {
		return new ScoreGetDetailUseCase(scoreRepository);
	}

	@Bean
	public ScoreUpdateUseCase scoreUpdateUseCase(
		ScoreRepository scoreRepository,
		SubjectRepository subjectRepository,
		StudentRepository studentRepository
	) {
		return new ScoreUpdateUseCase(scoreRepository, subjectRepository, studentRepository);
	}

	@Bean
	public ScoreCreateUseCase scoreCreateUseCase(
		ScoreRepository scoreRepository,
		SubjectRepository subjectRepository,
		StudentRepository studentRepository
	) {
		return new ScoreCreateUseCase(scoreRepository, subjectRepository, studentRepository);
	}

	@Bean
	public ScoreSearchUseCase scoreSearchUseCase(ScoreRepository scoreRepository) {
		return new ScoreSearchUseCase(scoreRepository);
	}

	@Bean
	public ScoreDeleteUseCase scoreDeleteUseCase(ScoreRepository scoreRepository) {
		return new ScoreDeleteUseCase(scoreRepository);
	}

	@Bean
	public SubjectDeleteUseCase subjectDeleteUseCase(SubjectRepository subjectRepository) {
		return new SubjectDeleteUseCase(subjectRepository);
	}

	@Bean
	public SubjectUpdateUseCase subjectUpdateUseCase(SubjectRepository subjectRepository) {
		return new SubjectUpdateUseCase(subjectRepository);
	}

	@Bean
	public SubjectCrateUseCase subjectCreateUseCase(SubjectRepository subjectRepository) {
		return new SubjectCrateUseCase(subjectRepository);
	}

	@Bean
	public SubjectGetDetailUseCase subjectGetDetailUseCase(SubjectRepository subjectRepository) {
		return new SubjectGetDetailUseCase(subjectRepository);
	}

	@Bean
	public SubjectSearchUseCase subjectSearchUseCase(SubjectRepository subjectRepository) {
		return new SubjectSearchUseCase(subjectRepository);
	}

	@Bean
	public StudentCrateUseCase studentCrateUseCase(StudentRepository studentRepository) {
		return new StudentCrateUseCase(studentRepository);
	}

	@Bean
	public StudentUpdateUseCase studentUpdateUseCase(StudentRepository studentRepository) {
		return new StudentUpdateUseCase(studentRepository);
	}

	@Bean
	public StudentGetDetailUseCase studentGetDetailUseCase(
		StudentRepository studentRepository,
		ScoreRepository scoreRepository
	) {
		return new StudentGetDetailUseCase(studentRepository, scoreRepository);
	}

	@Bean
	public StudentSearchUseCase studentSearchUseCase(StudentRepository studentRepository) {
		return new StudentSearchUseCase(studentRepository);
	}


	@Bean
	public LoginUseCase loginUseCase(UserAuthenticationManager authenticationManager) {
		return new LoginUseCase(authenticationManager);
	}

	@Bean
	public SignupUseCase signupUseCase(
		UserRepository userRepository, PasswordEncoder passwordEncoder
	) {
		return new SignupUseCase(userRepository, passwordEncoder);
	}

}
