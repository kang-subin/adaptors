package com.multitap.aifeedback.application.port.out;

import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackContentResponseVo;
import org.springframework.stereotype.Component;

@Component
public interface KafkaPort {

    void sendFeedbackRecordGptResponse(FeedbackContentResponseVo feedbackContentResponseVo);
}
