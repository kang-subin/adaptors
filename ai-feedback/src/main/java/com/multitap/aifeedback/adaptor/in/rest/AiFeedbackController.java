package com.multitap.aifeedback.adaptor.in.rest;

import com.multitap.aifeedback.adaptor.in.mapper.OcrVoMapper;
import com.multitap.aifeedback.adaptor.in.mapper.PromptVoMapper;
import com.multitap.aifeedback.adaptor.in.vo.TextRequestVo;
import com.multitap.aifeedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.aifeedback.application.port.in.GptUseCase;
import com.multitap.aifeedback.application.port.in.OcrUseCase;
import com.multitap.aifeedback.application.port.in.PromptUseCase;
import com.multitap.aifeedback.application.port.in.dto.in.CombinedPromptRequestDto;
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
    private final PromptUseCase promptUseCase;
    private final GptUseCase gptUseCase;

    @Operation(summary = "pdf 파일 업로드", description = "[이력서, 포트폴리오] pdf 파일 용량은 10MB로 제한")
    @PostMapping(value = "/pdf", consumes = "multipart/form-data")
    public BaseResponse<Object> pdfSubmit(@RequestParam("file") MultipartFile file, @RequestParam("industryType") String industryType,
                                                        @RequestParam("documentType") String documentType) throws IOException {

        log.info("산업,문서타입: {},{}", industryType, documentType);

        // OCR 분석
        OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest = ocrUseCase.uploadPdfForOcr(OcrVoMapper.from(file));
        log.info("ocr 분석 완료 : {}", ocrProcessedFeedbackRequest.getContent());

        // 프롬프트 가져오기
        PromptDetailsResponseVo promptDetailsResponseVo = promptUseCase.sendRequestPrompt(PromptVoMapper.from(industryType, documentType));
        log.info("프롬프트 : {}", promptDetailsResponseVo.getRequest());

        // GPT 피드백 요청 (ocr 값 + prompt 값 합쳐서 전달)
        Object aiFeedbackResponseVo = gptUseCase.sendFeedbackRequestToGpt(CombinedPromptRequestDto.of(ocrProcessedFeedbackRequest, promptDetailsResponseVo));

        return new BaseResponse<>(aiFeedbackResponseVo);
    }

    @Operation(summary = "text 업로드", description = "[자소서] text 제한 1500자")
    @PostMapping("text")
    public BaseResponse<Object> textSubmit(@RequestParam("industryType") String industryType, @RequestParam("documentType") String documentType, @RequestBody TextRequestVo textRequestVo) throws IOException {

        // 프롬프트 가져오기
        PromptDetailsResponseVo promptDetailsResponseVo = promptUseCase.sendRequestPrompt(PromptVoMapper.from(industryType, documentType));

        // GPT 피드백 요청
        Object aiFeedbackResponseVo = gptUseCase.sendFeedbackRequestToGpt(CombinedPromptRequestDto.of(textRequestVo, promptDetailsResponseVo));

        return new BaseResponse<>(aiFeedbackResponseVo);
    }
}