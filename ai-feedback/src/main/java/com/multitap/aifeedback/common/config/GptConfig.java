package com.multitap.aifeedback.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class GptConfig extends BaseRestTemplateConfig {

    @Value("${gpt.api.key}")
    private String gptKey;

    @Bean(name = "gptRestTemplate")
    public RestTemplate gptRestTemplate() {
        if (gptKey == null || gptKey.isBlank()) {
            throw new IllegalStateException("GPT API key is not configured. Please check your application properties.");
        }
        log.info("Initializing GPT RestTemplate...");
        return createRestTemplate("Authorization", "Bearer " + gptKey);
    }
}


