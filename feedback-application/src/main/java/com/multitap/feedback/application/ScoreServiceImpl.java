package com.multitap.feedback.application;

import com.multitap.feedback.common.exception.BaseException;
import com.multitap.feedback.common.response.BaseResponseStatus;
import com.multitap.feedback.dto.FeedbackElementResponseDto;
import com.multitap.feedback.dto.FeedbackScoreRequestDto;
import com.multitap.feedback.entity.FeedbackElement;
import com.multitap.feedback.infrastructure.FeedbackElementRepository;
import com.multitap.feedback.infrastructure.FeedbackScoreRepository;
import com.multitap.feedback.kafka.producer.FeedbackScoreDto;
import com.multitap.feedback.kafka.producer.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ScoreServiceImpl implements ScoreService {

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
