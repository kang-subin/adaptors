package com.multitap.aifeedback.adaptor.in.kafka;


import com.multitap.aifeedback.adaptor.in.kafka.messagein.FeedbackScorePromptDto;
import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackContentResponseVo;
import com.multitap.aifeedback.application.port.in.GptUseCase;
import com.multitap.aifeedback.application.port.in.KafkaUseCase;
import com.multitap.aifeedback.application.port.in.dto.in.AiRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaConsumer {

    private final GptUseCase gptUseCase;
    private final KafkaUseCase kafkaUseCase;


    // 피드백 쿼리에서 프롬프트랑 결합하여 프롬프트에서 토픽 보낸거 받아서 gpt 요청
    @KafkaListener(topics = "create-category-prompt-topic", groupId = "feedback-consumer-group", containerFactory = "feedbackScorePromptDtoListener")
    public void processFeedbackScorePrompt(FeedbackScorePromptDto feedbackScorePromptDto) {
        // gpt 피드백 요청
        Object gptResponseVo = gptUseCase.sendFeedbackRequestToGpt(AiRequestDto.of(feedbackScorePromptDto.getFeedbackScoreDto(),feedbackScorePromptDto.getPromptDetails()));

        log.info("uuid :{}", feedbackScorePromptDto.getFeedbackScoreDto().getUuid());
        //kafka topic 발행
        kafkaUseCase.sendFeedbackScoreResult(FeedbackContentResponseVo.from(feedbackScorePromptDto.getFeedbackScoreDto().getUuid(), feedbackScorePromptDto.getFeedbackScoreDto().getCategoryCode(),gptResponseVo));
    }
}
