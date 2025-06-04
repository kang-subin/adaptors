package com.multitap.aifeedback.adaptor.out.gpt.presentation;

import com.multitap.aifeedback.application.port.in.dto.in.CombinedPromptRequestDto;
import com.multitap.aifeedback.application.port.in.dto.in.GptRequestDto;
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
    public Object callGptApi(CombinedPromptRequestDto combinedPromptRequestDto) {

        String gptResponseContent = gptRestTemplate.postForObject(
                apiUrl,
                GptRequestDto.from(
                        model,
                        combinedPromptRequestDto.getRequest() +
                                combinedPromptRequestDto.getPromptDetails().getRequest() +
                                combinedPromptRequestDto.getPromptDetails().getReplyFormat()
                ),
                GptResponseDto.class
        ).getChoices().get(0).getMessage().getContent();

        log.info("GPT 응답: {}", gptResponseContent);

        return CombinedPromptRequestDto.processResponse(combinedPromptRequestDto.getRequest(), gptResponseContent);
    }
}