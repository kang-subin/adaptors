package com.multitap.aifeedback.adaptor.out.prompt.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multitap.aifeedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.aifeedback.application.port.in.dto.in.RetrievePromptRequestVo;
import com.multitap.aifeedback.application.port.out.PromptApiPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@Slf4j
public class PromptApiAdapter implements PromptApiPort {

    private final RestTemplate promptRestTemplate;

    @Value("${prompt.api.url}")
    private String apiUrl;

    public PromptApiAdapter(@Qualifier("promptRestTemplate") RestTemplate promptRestTemplate) {
        this.promptRestTemplate = promptRestTemplate;
    }

    @Override
    public PromptDetailsResponseVo callPromptApi(RetrievePromptRequestVo retrievePromptRequestVo) {
        try {

            ResponseEntity<Map> response = promptRestTemplate.postForEntity(
                    apiUrl,
                    retrievePromptRequestVo,
                    Map.class
            );

            log.info("프롬프트 API 응답: {}", response.getBody());

            // 응답의 result 부분을 가져와서 PromptDetailsResponseVo로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            PromptDetailsResponseVo result = objectMapper.convertValue(
                    response.getBody().get("result"),
                    PromptDetailsResponseVo.class
            );

            log.info("변환된 응답 결과: {}", result);

            return result;

        } catch (Exception e) {
            log.error("프롬프트 API 호출 중 오류 발생: ", e);
            throw new RuntimeException("프롬프트 API 호출 실패", e);
        }
    }

    //todo: 여기서 프롬프트랑 요청값 정돈해서 아웃포트를 나오면


}