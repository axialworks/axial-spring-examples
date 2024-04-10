package com.axial.examples.multiple_database.database.test_db.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class TestDatasourceConfiguration {

    @Bean(name = "dataSourcePropertiesTest")
    @Primary
    @ConfigurationProperties("spring.datasource.test")
    public DataSourceProperties testDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "dataSourceTest")
    public DataSource testDataSource() {

        /*
            Another Solution:

             return DataSourceBuilder.create()
                .url("jdbc:h2:mem:db1")
                .driverClassName("org.h2.Driver")
                .username("sa")
                .password("")
                .build();

         */


        return testDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();


        //return DataSourceBuilder.create().build();
    }

}
