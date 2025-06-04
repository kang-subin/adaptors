package com.multitap.aifeedback.application.port.in;

import com.multitap.aifeedback.application.port.in.dto.in.CombinedPromptRequestDto;

public interface GptUseCase {

    Object sendFeedbackRequestToGpt(CombinedPromptRequestDto combinedPromptRequestDto);
}

