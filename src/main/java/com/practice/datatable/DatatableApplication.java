package com.practice.datatable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.practice.datatable"})
public class DatatableApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatatableApplication.class, args);
    }

}
