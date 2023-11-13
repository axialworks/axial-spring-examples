package com.axial.examples.database.test_db.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

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
public class TestJdbcConfiguration {

    /*
     * Example Usage:

         @Autowired
         @Qualifier("jdbcTemplateApp")
         JdbcTemplate jdbcTemplate;

     */
    @Bean(name = "jdbcTemplateTest")
    public JdbcTemplate testJdbcTemplate(
            @Qualifier("dataSourceTest") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /*
     * Example Usage:

         @Autowired
         @Qualifier("namedJdbcTemplateTest")
         NamedParameterJdbcTemplate namedParameterJdbcTemplate;

     */
    @Bean(name = "namedParameterJdbcTemplateTest")
    public NamedParameterJdbcTemplate testNamedParameterJdbcTemplate(
            @Qualifier("dataSourceTest") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
