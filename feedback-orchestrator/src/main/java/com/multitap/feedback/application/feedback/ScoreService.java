package com.multitap.feedback.application.feedback;

import com.multitap.feedback.dto.feedback.ElementResponseDto;
import com.multitap.feedback.dto.feedback.ScoreRequestDto;

import java.util.List;

public interface ScoreService {
    void addScore(ScoreRequestDto scoreRequestDto);
    List<ElementResponseDto> getFeedbackElement(String categoryCode);
}
