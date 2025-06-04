package com.multitap.feedbackquery.kafka.producer;


public interface KafkaProducerService {
    void sendCreateFeedbackScore(AiFeedbackScoreDto aiFeedbackScoreDto);
}
