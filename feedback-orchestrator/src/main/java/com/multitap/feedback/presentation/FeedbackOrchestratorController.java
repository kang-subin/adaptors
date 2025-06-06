package com.multitap.feedback.presentation;

import com.multitap.feedback.application.FeedbackOrchestratorService;
import com.multitap.feedback.common.response.BaseResponse;
import com.multitap.feedback.dto.feedback.FeedbackRequestDto;
import com.multitap.feedback.vo.FeedbackRequestVo;
import com.multitap.feedback.vo.FeedbackResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/feedback")
@RequiredArgsConstructor
@Slf4j
public class FeedbackOrchestratorController {

    private final FeedbackOrchestratorService feedbackOrchestratorService;

    @Operation(summary = "이력서, 포트폴리오 pdf 파일 업로드", description = "pdf 파일 용량은 10MB로 제한")
    @PostMapping(value = "/pdf", consumes = "multipart/form-data")
    public BaseResponse<FeedbackResponseVo> pdfSubmit(@RequestBody FeedbackRequestVo feedbackRequestVo) {
        FeedbackResponseVo feedbackResponseVo = feedbackOrchestratorService.processFeedback(FeedbackRequestDto.from(feedbackRequestVo)).toVo();
        return new BaseResponse<>(feedbackResponseVo);
    }
}
