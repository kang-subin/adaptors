package com.multitap.feedbackquery.kafka.consumer;

import com.multitap.feedbackquery.dto.in.FeedbackScoreContentDto;
import com.multitap.feedbackquery.dto.in.FeedbackScoreRequestDto;

public interface KafkaConsumerService {
    void addFeedbackScore(FeedbackScoreRequestDto feedbackScoreRequestDto, String uuid);
    void addFeedbackContent(FeedbackScoreContentDto feedbackScoreContentDto, String uuid);
}
