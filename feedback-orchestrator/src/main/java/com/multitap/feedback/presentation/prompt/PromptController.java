package com.multitap.feedback.presentation.prompt;

import com.multitap.feedback.application.prompt.PromptService;
import com.multitap.feedback.common.response.BaseResponse;
import com.multitap.feedback.dto.prompt.PromptRequestDto;
import com.multitap.feedback.dto.prompt.PromptResponseDto;
import com.multitap.feedback.vo.prompt.PromptRequestVo;
import com.multitap.feedback.vo.prompt.PromptResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "프롬프트 API", description = "프롬프트 CRUD API endpoints")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/prompt")
public class PromptController {

    private final PromptService promptService;

    @Operation(summary = "프롬프트 등록", description = "프롬프트 등록")
    @PostMapping()
    public BaseResponse<Void> addPrompt(@RequestBody PromptRequestVo promptRequestVo) {
        promptService.addPrompt(PromptRequestDto.from(promptRequestVo));
        return new BaseResponse<>();
    }

    @Operation(summary = "프롬프트 리스트 조회", description = "프롬프트 리스트 조회")
    @GetMapping()
    public BaseResponse<List<PromptResponseVo>> getPrompt() {
        List<PromptResponseVo> promptResponseVoList = promptService.getPromptList()
                .stream()
                .map(PromptResponseDto::toVo)
                .toList();
        return new BaseResponse<>(promptResponseVoList);
    }

    @Operation(summary = "프롬프트 수정", description = "프롬프트 수정")
    @PutMapping("/{id}")
    public BaseResponse<Void> getPrompt(@PathVariable Long id, @RequestBody PromptRequestVo promptRequestVo) {
        promptService.changePrompt(PromptRequestDto.from(promptRequestVo), id);
        return new BaseResponse<>();
    }

}
