package com.axial.examples.database.app_db.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

/*
    Example Usage:2204

        @Repository
        @Transactional(transactionManager = "transactionManagerApp")
        public interface Entity1Repository extends JpaRepository<Entity1, Long> {
            // Custom query methods
        }

 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {
                "com.axial.examples.database.app_db.repository.jpa",
                "com.axial.examples.database.app_db.repository.entity_manager"
        },
        entityManagerFactoryRef = "entityManagerFactoryApp",
        transactionManagerRef = "transactionManagerApp"
)
public class AppJpaConfiguration {

    @Bean(name = "entityManagerFactoryBuilderApp")
    public EntityManagerFactoryBuilder testEntityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(),
                new HashMap<>(), null);
    }

    @Primary
    @Bean(name = "entityManagerFactoryApp")
    public LocalContainerEntityManagerFactoryBean appEntityManagerFactory(
            @Qualifier("entityManagerFactoryBuilderApp") EntityManagerFactoryBuilder builder,
            @Qualifier("dataSourceApp") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.axial.examples.database.app_db.entity")
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerApp")
    public PlatformTransactionManager appTransactionManager(
            @Qualifier("entityManagerFactoryApp")
            EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
