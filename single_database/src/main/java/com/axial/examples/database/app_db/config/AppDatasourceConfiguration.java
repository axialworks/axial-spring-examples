package com.axial.examples.database.app_db.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class AppDatasourceConfiguration {

    @Primary
    @Bean(name = "dataSourcePropertiesApp")
    @ConfigurationProperties("spring.datasource.app")
    public DataSourceProperties appDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "dataSourceApp")
    public DataSource appDataSource() {

        /*
            Another Solution:

             return DataSourceBuilder.create()
                .url("jdbc:h2:mem:db1")
                .driverClassName("org.h2.Driver")
                .username("sa")
                .password("")
                .build();

         */


        return appDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();


        //return DataSourceBuilder.create().build();
    }

}
