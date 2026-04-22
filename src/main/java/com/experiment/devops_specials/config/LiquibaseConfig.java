package com.experiment.devops_specials.config;

import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Log4j2
public class LiquibaseConfig {

    /**
     * Configure Liquibase for Dev environment
     */
    @Bean
    @Profile("dev")
    public SpringLiquibase liquibaseDev(DataSource dataSource) {
        log.info("Initializing Liquibase for DEV environment");
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-dev.xml");
        liquibase.setShouldRun(true);
        liquibase.setContexts("dev");
        return liquibase;
    }

    /**
     * Configure Liquibase for Prod environment
     */
    @Bean
    @Profile("prod")
    public SpringLiquibase liquibaseProd(DataSource dataSource) {
        log.info("Initializing Liquibase for PROD environment");
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-prod.xml");
        liquibase.setShouldRun(true);
        liquibase.setContexts("prod");
        return liquibase;
    }

    /**
     * Configure Liquibase for Local environment
     */
    @Bean
    @Profile("local")
    public SpringLiquibase liquibaseLocal(DataSource dataSource) {
        log.info("Initializing Liquibase for LOCAL environment");
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-local.xml");
        liquibase.setShouldRun(true);
        liquibase.setContexts("local");
        return liquibase;
    }
}
