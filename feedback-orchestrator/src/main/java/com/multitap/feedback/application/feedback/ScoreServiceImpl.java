package com.multitap.feedback.application.feedback;

import com.multitap.feedback.dto.feedback.ElementResponseDto;
import com.multitap.feedback.dto.feedback.ScoreRequestDto;
import com.multitap.feedback.infrastructure.repository.feedback.ElementRepository;
import com.multitap.feedback.infrastructure.repository.feedback.ScoreRepository;
import com.multitap.feedback.infrastructure.kafka.FeedbackScoreDto;
import com.multitap.feedback.infrastructure.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final ElementRepository elementRepository;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public void addScore(ScoreRequestDto scoreRequestDto) {
        kafkaProducerService.sendFeedbackScore(FeedbackScoreDto.from(scoreRepository.save(scoreRequestDto.toEntity(scoreRequestDto))));
    }

    @Override
    public List<ElementResponseDto> getFeedbackElement(String categoryCode) {
       return elementRepository.findByCategoryCode(categoryCode)
               .stream()
               .map(ElementResponseDto::from)
               .toList();
    }
}
