package com.multitap.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FeedbackOrchestrator {

    public static void main(String[] args) {
        SpringApplication.run(FeedbackOrchestrator.class, args);
    }

}
