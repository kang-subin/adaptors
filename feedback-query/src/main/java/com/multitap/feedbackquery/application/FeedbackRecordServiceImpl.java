package com.multitap.feedbackquery.application;

import com.multitap.feedbackquery.dto.in.FeedbackRecordRequestDto;
import com.multitap.feedbackquery.dto.out.FeedbackContentDto;
import com.multitap.feedbackquery.dto.out.FeedbackContentResponseDto;
import com.multitap.feedbackquery.dto.out.FeedbackFirstLastScoreDto;
import com.multitap.feedbackquery.dto.out.FeedbackRecordResponseDto;
import com.multitap.feedbackquery.entity.FeedbackRecord;
import com.multitap.feedbackquery.infrastructure.FeedbackRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class FeedbackRecordServiceImpl implements FeedbackRecordService {

    private final FeedbackRecordRepository feedbackRecordRepository;

    @Override
    public List<FeedbackRecordResponseDto> getFeedbackScore(FeedbackRecordRequestDto feedbackRecordRequestDto) {
        return feedbackRecordRepository.findByIdAndCategoryCodeOrderByMentoringDateDesc(feedbackRecordRequestDto.getUuid(), feedbackRecordRequestDto.getCategoryCode())
                .map(FeedbackRecord::getFeedbackScore)
                .orElse(List.of())
                .stream()
                .map(FeedbackRecordResponseDto::from)
                .toList();
    }

    @Override
    public FeedbackContentResponseDto getFeedbackFirstLastScoreAndContent(FeedbackRecordRequestDto feedbackRecordRequestDto) {
        FeedbackFirstLastScoreDto feedbackFirstLastScoreDto = feedbackRecordRepository.findFirstAndLastFeedbackScore(feedbackRecordRequestDto.getUuid(), feedbackRecordRequestDto.getCategoryCode());
        String content = feedbackRecordRepository.findFeedbackContentByIdAndCategory(feedbackRecordRequestDto.getUuid(), feedbackRecordRequestDto.getCategoryCode());
        log.info("컨텐트: {}", content);
        return FeedbackContentResponseDto.builder()
                .feedbackFirstLastScoreDto(feedbackFirstLastScoreDto)
                .feedbackContentDto(content)
                .build();
    }
}


