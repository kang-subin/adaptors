package com.multitap.aifeedback.application.port.in;


import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackContentResponseVo;

public interface KafkaUseCase {
    void sendFeedbackScoreResult(FeedbackContentResponseVo feedbackContentResponseVo);
}
