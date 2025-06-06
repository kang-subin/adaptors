package com.multitap.aifeedback.application.port.out;

import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackResponseVo;
import com.multitap.aifeedback.application.port.in.dto.in.AiRequestDto;
import org.springframework.stereotype.Component;

@Component
public interface GptApiPort {

    FeedbackResponseVo callGptApi(AiRequestDto aiRequestDto);
}
