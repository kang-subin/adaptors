package com.multitap.feedback.application;

import com.multitap.feedback.application.ai.AiService;
import com.multitap.feedback.application.prompt.PromptService;
import com.multitap.feedback.application.score.ScoreService;
import com.multitap.feedback.dto.feedback.FeedbackRequestDto;
import com.multitap.feedback.dto.feedback.FeedbackResponseDto;
import com.multitap.feedback.dto.score.ScoreRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedbackOrchestratorServiceImpl implements FeedbackOrchestratorService {

    private final ScoreService scoreService;
    private final PromptService promptService;
    private final AiService aiService;

    // 프롬프트 조회 -> ai 피드백 요청 -> 피드백 보여주기 및 -> 피드백 카프카로 전송
    @Override
    public FeedbackResponseDto processFeedback(FeedbackRequestDto feedbackRequestDto) {
        // prompt 조회
        String prompt = promptService.getPrompt(feedbackRequestDto.getIndustry(), feedbackRequestDto.getDocumentType());

        //ai 피드백 요청
        FeedbackResponseDto feedbackResponseDto = aiService.createAiFeedback(prompt,feedbackRequestDto.getFile());

        return null;
    }

    @Override
    public void processScore(ScoreRequestDto scoreRequestDto) {

    }
}
