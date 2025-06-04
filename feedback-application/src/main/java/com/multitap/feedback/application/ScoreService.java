package com.multitap.feedback.application;

import com.multitap.feedback.dto.FeedbackElementResponseDto;
import com.multitap.feedback.dto.FeedbackScoreRequestDto;

import java.util.List;

public interface ScoreService {
    void addScore(FeedbackScoreRequestDto feedbackScoreRequestDto);
    List<FeedbackElementResponseDto> getFeedbackElement(String categoryCode);
}
