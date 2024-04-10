package com.axial.examples.multiple_database.database.test_db.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

/*
    Example Usage:

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
                "com.axial.examples.multiple_database.database.test_db.repository.jpa",
                "com.axial.examples.multiple_database.database.test_db.repository.entity_manager"
        },
        entityManagerFactoryRef = "entityManagerFactoryTest",
        transactionManagerRef = "transactionManagerTest"
)
public class TestJpaConfiguration {

    @Bean(name = "entityManagerFactoryBuilderTest")
    public EntityManagerFactoryBuilder testEntityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(),
                new HashMap<>(), null);
    }

    @Bean(name = "entityManagerFactoryTest")
    public LocalContainerEntityManagerFactoryBean testEntityManagerFactory(
            @Qualifier("entityManagerFactoryBuilderTest") EntityManagerFactoryBuilder builder,
            @Qualifier("dataSourceTest") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.axial.examples.multiple_database.database.test_db.entity")
                .build();
    }

    @Bean(name = "transactionManagerTest")
    public PlatformTransactionManager testTransactionManager(
            @Qualifier("entityManagerFactoryTest")
            EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
