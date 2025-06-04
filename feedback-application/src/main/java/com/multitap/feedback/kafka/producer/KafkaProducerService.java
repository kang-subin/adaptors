package com.multitap.feedback.kafka.producer;

public interface KafkaProducerService {
    void sendFeedbackScore(FeedbackScoreDto feedbackScoreDto);
}
