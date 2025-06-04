package com.multitap.aifeedback.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
public abstract class BaseRestTemplateConfig {

    protected RestTemplate createRestTemplate(String authHeaderName, String authHeaderValue) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            log.info("Adding {} Header...", authHeaderName);
            request.getHeaders().add(authHeaderName, authHeaderValue);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
