package com.multitap.aifeedback.application.port.out;

import com.multitap.aifeedback.application.port.in.dto.in.CombinedPromptRequestDto;
import org.springframework.stereotype.Component;

@Component
public interface GptApiPort {

    Object callGptApi(CombinedPromptRequestDto combinedPromptRequestDto);
}
