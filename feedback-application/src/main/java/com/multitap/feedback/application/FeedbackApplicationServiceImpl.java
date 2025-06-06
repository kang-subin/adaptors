package com.multitap.feedback.application;

import com.multitap.feedback.dto.FeedbackElementResponseDto;
import com.multitap.feedback.dto.FeedbackScoreRequestDto;
import com.multitap.feedback.infrastructure.repository.FeedbackElementRepository;
import com.multitap.feedback.infrastructure.repository.FeedbackScoreRepository;
import com.multitap.feedback.infrastructure.kafka.FeedbackScoreDto;
import com.multitap.feedback.infrastructure.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FeedbackApplicationServiceImpl implements FeedbackApplicationService {

    private final FeedbackScoreRepository feedbackScoreRepository;
    private final FeedbackElementRepository feedbackElementRepository;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public void addScore(FeedbackScoreRequestDto feedbackScoreRequestDto) {
        kafkaProducerService.sendFeedbackScore(FeedbackScoreDto.from(feedbackScoreRepository.save(feedbackScoreRequestDto.toEntity(feedbackScoreRequestDto))));
    }

    @Override
    public List<FeedbackElementResponseDto> getFeedbackElement(String categoryCode) {
       return feedbackElementRepository.findByCategoryCode(categoryCode)
               .stream()
               .map(FeedbackElementResponseDto::from)
               .toList();
    }
}
