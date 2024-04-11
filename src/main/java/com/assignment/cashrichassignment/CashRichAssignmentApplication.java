package com.assignment.cashrichassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CashRichAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CashRichAssignmentApplication.class, args);
    }

}
