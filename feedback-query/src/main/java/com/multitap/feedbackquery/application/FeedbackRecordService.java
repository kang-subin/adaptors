package com.multitap.feedbackquery.application;

import com.multitap.feedbackquery.dto.in.FeedbackRecordRequestDto;
import com.multitap.feedbackquery.dto.out.FeedbackContentResponseDto;
import com.multitap.feedbackquery.dto.out.FeedbackRecordResponseDto;

import java.util.List;

public interface FeedbackRecordService {
    List<FeedbackRecordResponseDto> getFeedbackScore(FeedbackRecordRequestDto feedbackRecordRequestDto);
    FeedbackContentResponseDto getFeedbackFirstLastScoreAndContent(FeedbackRecordRequestDto feedbackRecordRequestDto);
}
