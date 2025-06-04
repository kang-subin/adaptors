package com.multitap.aifeedback.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
public class OcrConfig {

    @Value("${ocr.api.key}")
    private String ocrKey;

    @Bean(name = "ocrRestTemplate")
    public RestTemplate ocrRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((request, body, execution) -> {
            HttpHeaders headers = request.getHeaders();
            headers.add("X-OCR-SECRET", ocrKey); // 인증 헤더 추가
            return execution.execute(request, body);
        });

        return restTemplate;
    }
}