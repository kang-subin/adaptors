package com.multitap.aifeedback.adaptor.out.gpt.presentation;

import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackResponseVo;
import com.multitap.aifeedback.application.port.in.dto.in.AiRequestDto;
import com.multitap.aifeedback.application.port.in.dto.in.GptRequestDto;
import com.multitap.aifeedback.application.port.in.dto.out.FeedbackResponseDto;
import com.multitap.aifeedback.application.port.in.dto.out.GptResponseDto;
import com.multitap.aifeedback.application.port.out.GptApiPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@Slf4j
public class GptApiAdapter implements GptApiPort {

    private final RestTemplate gptRestTemplate;

    public GptApiAdapter(@Qualifier("gptRestTemplate") RestTemplate gptRestTemplate) {
        this.gptRestTemplate = gptRestTemplate;
    }

    @Value("${gpt.model}")
    private String model;

    @Value("${gpt.api.url}")
    private String apiUrl;


    @Override
    public FeedbackResponseVo callGptApi(AiRequestDto aiRequestDto) {

        FeedbackResponseDto feedbackResponseDto = FeedbackResponseDto.of(gptRestTemplate.postForObject(
                apiUrl,
                GptRequestDto.from(
                        model,
                        aiRequestDto.getPrompt() +
                                aiRequestDto.getOcrResponse()
                ),
                GptResponseDto.class
        ).getChoices().get(0).getMessage().getContent());

        log.info("GPT 응답: {}", feedbackResponseDto.getContent());

        return feedbackResponseDto.toVo();
    }
}