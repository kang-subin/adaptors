package com.multitap.aifeedback.application.service;

import com.multitap.aifeedback.application.port.in.GptUseCase;
import com.multitap.aifeedback.application.port.in.dto.in.CombinedPromptRequestDto;
import com.multitap.aifeedback.application.port.out.GptApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GptService implements GptUseCase {

    private final GptApiPort gptApiPort;

    @Override
    public Object sendFeedbackRequestToGpt(CombinedPromptRequestDto combinedPromptRequestDto) {
        return gptApiPort.callGptApi(combinedPromptRequestDto);
    }
}

