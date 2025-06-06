package com.multitap.aifeedback.adaptor.in.rest;

import com.multitap.aifeedback.adaptor.in.mapper.OcrVoMapper;
import com.multitap.aifeedback.adaptor.in.vo.TextRequestVo;
import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackResponseVo;
import com.multitap.aifeedback.application.port.in.GptUseCase;
import com.multitap.aifeedback.application.port.in.OcrUseCase;
import com.multitap.aifeedback.application.port.in.dto.in.AiRequestDto;
import com.multitap.aifeedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.aifeedback.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/ai-feedback")
@RequiredArgsConstructor
@Slf4j
public class AiFeedbackController {

    private final OcrUseCase ocrUseCase;
    private final GptUseCase gptUseCase;

    @Operation(summary = "pdf 파일 업로드", description = "[이력서, 포트폴리오] pdf 파일 용량은 10MB로 제한")
    @PostMapping(value = "/pdf", consumes = "multipart/form-data")
    public BaseResponse<FeedbackResponseVo> pdfSubmit(@RequestBody String prompt, @RequestParam("file") MultipartFile file) throws IOException {
        // OCR 분석
        OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest = ocrUseCase.uploadPdfForOcr(OcrVoMapper.from(file));
        log.info("ocr 분석 완료 : {}", ocrProcessedFeedbackRequest.getContent());

        // GPT 피드백 요청
        FeedbackResponseVo feedbackResponseVo = gptUseCase.sendFeedbackRequestToGpt(AiRequestDto.of(ocrProcessedFeedbackRequest.getContent(), prompt));

        return new BaseResponse<>(feedbackResponseVo);
    }

//
//    @Operation(summary = "text 업로드", description = "[자소서] text 제한 1500자")
//    @PostMapping("text")
//    public BaseResponse<Object> textSubmit(@RequestParam("industryType") String industryType, @RequestParam("documentType") String documentType, @RequestBody TextRequestVo textRequestVo) throws IOException {
//        // GPT 피드백 요청
//        Object aiFeedbackResponseVo = gptUseCase.sendFeedbackRequestToGpt(AiRequestDto.of(textRequestVo, promptDetailsResponseVo));
//
//        return new BaseResponse<>(aiFeedbackResponseVo);
//    }
}