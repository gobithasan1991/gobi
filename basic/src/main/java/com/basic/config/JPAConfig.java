package com.basic.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration 
@EnableJpaRepositories(basePackages = {"com.basic.persitance.repository"})
@EntityScan(basePackages = "com.basic.persitance.model")
@EnableJpaAuditing
@EnableTransactionManagement
@EnableSpringDataWebSupport
public class JPAConfig {

}
