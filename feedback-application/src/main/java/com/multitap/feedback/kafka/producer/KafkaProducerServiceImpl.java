package com.multitap.feedback.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendFeedbackScore(FeedbackScoreDto feedbackScoreDto) {
        try {
            log.info("피드백 보내는 값: {}", feedbackScoreDto.getMentoringDate());

            // feedbackQuery 서비스에서 컨슘 받음

            kafkaTemplate.send("create-feedback-score-topic", feedbackScoreDto);
        } catch (Exception e) {
            log.info("create feedback score event send 실패 : " + e);
            throw new RuntimeException(e);
        }
    }
}
