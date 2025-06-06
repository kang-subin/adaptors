package com.multitap.feedback.infrastructure.kafka;

public interface KafkaProducerService {
    void sendFeedbackScore(FeedbackScoreDto feedbackScoreDto);
}
