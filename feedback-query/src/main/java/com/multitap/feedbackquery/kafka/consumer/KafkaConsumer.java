package com.multitap.feedbackquery.kafka.consumer;

import com.multitap.feedbackquery.dto.in.FeedbackScoreContentDto;
import com.multitap.feedbackquery.dto.in.FeedbackScoreRequestDto;
import com.multitap.feedbackquery.kafka.consumer.messagein.FeedbackContentResponseVo;
import com.multitap.feedbackquery.kafka.consumer.messagein.FeedbackScoreDto;
import com.multitap.feedbackquery.vo.out.FeedbackRecordResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaConsumer {

    private final KafkaConsumerService kafkaConsumerService;

    //멘토가 피드백 점수 부여한 값을 전달 받아서 저장 함
    @KafkaListener(topics = "create-feedback-score-topic", groupId = "feedback-consumer-group", containerFactory = "feedbackScoreDtoListener")
    public void processFeedbackScore(FeedbackScoreDto feedbackScoreDto) {
        log.info("Received feedbackScoreDto :{}", feedbackScoreDto.getUuid());
        kafkaConsumerService.addFeedbackScore(FeedbackScoreRequestDto.from(feedbackScoreDto), feedbackScoreDto.getUuid());
    }

    // ai 에서 피드백 받은 값을 컨슘 받음
    @KafkaListener(topics = "create-feedback-record-gpt-topic", groupId = "feedback-consumer-group", containerFactory = "feedbackContentResponseVoListener")
    public void processFeedbackRecord(FeedbackContentResponseVo feedbackContentResponseVo) {
        log.info("Received feedbackContentResponseVo :{}", feedbackContentResponseVo.getUuid());
        kafkaConsumerService.addFeedbackContent(FeedbackScoreContentDto.from(feedbackContentResponseVo), feedbackContentResponseVo.getUuid());

    }


}
