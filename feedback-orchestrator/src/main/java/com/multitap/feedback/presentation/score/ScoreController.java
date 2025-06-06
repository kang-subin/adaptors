package com.multitap.feedback.presentation.score;

import com.multitap.feedback.application.score.ScoreService;
import com.multitap.feedback.common.response.BaseResponse;
import com.multitap.feedback.dto.score.ElementResponseDto;
import com.multitap.feedback.dto.score.ScoreRequestDto;
import com.multitap.feedback.vo.score.ElementResponseVo;
import com.multitap.feedback.vo.score.ScoreRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "피드백 점수 API", description = "피드백 관련 API endpoints")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/feedback-score")
public class ScoreController {

    private final ScoreService feedbackApplicationService;

    @Operation(summary = "피드백 점수 등록", description = "멘토 -> 멘티 멘토링 후 피드백 요소에 따른 점수 부여")
    @PostMapping()
    public BaseResponse<Void> addFeedbackScore(@RequestBody ScoreRequestVo scoreRequestVo, @RequestHeader("userUuid") String uuid) {
        feedbackApplicationService.addScore(ScoreRequestDto.from(scoreRequestVo, uuid));
        return new BaseResponse<>();
    }

    @Operation(summary = "피드백 요소 조회", description = "멘토가 각 카테고리 별 피드백 요소 조회할 때 사용.")
    @GetMapping("/{categoryCode}")
    public BaseResponse<List<ElementResponseVo>> getFeedbackElement(@PathVariable String categoryCode) {
        List<ElementResponseVo> elementResponseVoList = feedbackApplicationService.getFeedbackElement(categoryCode)
                .stream()
                .map(ElementResponseDto::toVo)
                .toList();
        return new BaseResponse<>(elementResponseVoList);
    }
}
