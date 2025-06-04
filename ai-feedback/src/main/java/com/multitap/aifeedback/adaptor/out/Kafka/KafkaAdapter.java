package com.multitap.aifeedback.adaptor.out.Kafka;

import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackContentResponseVo;
import com.multitap.aifeedback.application.port.out.KafkaPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaAdapter implements KafkaPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendFeedbackRecordGptResponse(FeedbackContentResponseVo feedbackContentResponseVo) {
        try {
            log.info("uuid: {}", feedbackContentResponseVo.getUuid());

            // 피드백쿼리+프롬프트 -> ai 로 전달하여 gpt 처리 후 다시 쿼리로 전달
            kafkaTemplate.send("create-feedback-record-gpt-topic", feedbackContentResponseVo);
        } catch (Exception e) {
            log.info("create feedback record gpt event send 실패 : " + e);
            throw new RuntimeException(e);
        }
    }
}
