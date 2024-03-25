package com.axial.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

@ComponentScan(basePackageClasses = {
        PackageMarker.class,
        com.axial.examples.database.app_db.PackageMarker.class,
        com.axial.examples.database.test_db.PackageMarker.class,
        com.axial.examples.database.app_db.config.AppJpaConfiguration.class,
        com.axial.examples.database.test_db.config.TestJpaConfiguration.class,
        com.axial.modules.openapi.PackageMarker.class,
        com.axial.modules.commons.PackageMarker.class
})
@SpringBootApplication
@EnableConfigurationProperties
public class ExamplesPlaygroundApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ExamplesPlaygroundApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExamplesPlaygroundApplication.class);
    }


}
