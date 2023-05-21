package com.mx.alternativecourses.api.application.configuration.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("mx.finerio.pfm.api.repository")
@EntityScan("mx.finerio.pfm.api.entity")
@ComponentScan("mx.finerio.pfm.api")
@EnableTransactionManagement
public class DBConfig {

}
