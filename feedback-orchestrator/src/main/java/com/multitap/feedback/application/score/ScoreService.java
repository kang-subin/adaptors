package com.multitap.feedback.application.score;

import com.multitap.feedback.dto.score.ElementResponseDto;
import com.multitap.feedback.dto.score.ScoreRequestDto;

import java.util.List;

public interface ScoreService {
    void addScore(ScoreRequestDto scoreRequestDto);
    List<ElementResponseDto> getFeedbackElement(String categoryCode);
}
