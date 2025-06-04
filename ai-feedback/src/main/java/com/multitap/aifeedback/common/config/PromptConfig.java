package com.multitap.aifeedback.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PromptConfig {

    @Bean(name = "promptRestTemplate")
    public RestTemplate promptRestTemplate() {
        return new RestTemplate();
    }
}
