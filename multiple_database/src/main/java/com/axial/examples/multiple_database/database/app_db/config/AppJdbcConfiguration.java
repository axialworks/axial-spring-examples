package com.axial.examples.multiple_database.database.app_db.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/*
    Example Usage:

        @Service
        public class ProductService {

            private final JdbcTemplate jdbcTemplate;

            @Autowired
            public ProductService(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate) {
                this.jdbcTemplate = jdbcTemplate;
            }

            // Service methods (e.g., getAllProducts, addProduct, updateProduct, deleteProduct)
        }
 */
@Configuration
@EnableTransactionManagement
public class AppJdbcConfiguration {

    /*
     * Example Usage:

         @Autowired
         @Qualifier("jdbcTemplateApp")
         JdbcTemplate jdbcTemplate;

     */
    @Primary
    @Bean(name = "jdbcTemplateApp")
    public JdbcTemplate appJdbcTemplate(
            @Qualifier("dataSourceApp") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /*
     * Example Usage:

         @Autowired
         @Qualifier("namedJdbcTemplateApp")
         NamedParameterJdbcTemplate namedParameterJdbcTemplate;

     */
    @Primary
    @Bean(name = "namedParameterJdbcTemplateApp")
    public NamedParameterJdbcTemplate appNamedParameterJdbcTemplate(
            @Qualifier("dataSourceApp") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
