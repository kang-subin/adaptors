package com.multitap.feedback.application;

import com.multitap.feedback.dto.feedback.FeedbackRequestDto;
import com.multitap.feedback.dto.feedback.FeedbackResponseDto;
import com.multitap.feedback.dto.score.ScoreRequestDto;

public interface FeedbackOrchestratorService {
    //todo: 1. 파일 받아서 ai 결과 알려주기 (저장 -> query로 전송, 즉시 보여 주기, 리턴값 필요)
    FeedbackResponseDto processFeedback(FeedbackRequestDto feedbackRequestDto);

    void processScore(ScoreRequestDto scoreRequestDto);
    //todo: 2. 점수 저장 및 점수 변화가 있을 경우 ai 결과 후 query 로 이동 , (리턴값 불필요)

}
