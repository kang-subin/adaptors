package com.multitap.aifeedback.application.port.in;

import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackResponseVo;
import com.multitap.aifeedback.application.port.in.dto.in.AiRequestDto;

public interface GptUseCase {

    FeedbackResponseVo sendFeedbackRequestToGpt(AiRequestDto aiRequestDto);
}

