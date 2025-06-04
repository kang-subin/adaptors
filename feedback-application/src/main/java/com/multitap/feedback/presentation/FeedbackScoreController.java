package com.multitap.feedback.presentation;

import com.multitap.feedback.application.ScoreService;
import com.multitap.feedback.common.response.BaseResponse;
import com.multitap.feedback.dto.FeedbackElementResponseDto;
import com.multitap.feedback.dto.FeedbackScoreRequestDto;
import com.multitap.feedback.vo.FeedbackElementResponseVo;
import com.multitap.feedback.vo.FeedbackScoreRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Tag(name = "피드백 점수 API", description = "피드백 관련 API endpoints")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/feedback-score")
public class FeedbackScoreController {

    private final ScoreService scoreService;

    @Operation(summary = "피드백 점수 등록", description = "각 피드백 요소에 점수를 등록합니다.")
    @PostMapping()
    public BaseResponse<Void> addFeedbackScore(@RequestBody FeedbackScoreRequestVo feedbackScoreRequestVo, @RequestHeader("userUuid") String uuid) {
        scoreService.addScore(FeedbackScoreRequestDto.from(feedbackScoreRequestVo, uuid));
        return new BaseResponse<>();
    }

    @Operation(summary = "피드백 요소 조회", description = "각 카테고리별 피드백 요소 조회.")
    @GetMapping("/{categoryCode}")
    public BaseResponse<List<FeedbackElementResponseVo>> getFeedbackElement(@PathVariable String categoryCode) {
        List<FeedbackElementResponseVo> feedbackElementResponseVoList = scoreService.getFeedbackElement(categoryCode)
                .stream()
                .map(FeedbackElementResponseDto::toVo)
                .toList();
        return new BaseResponse<>(feedbackElementResponseVoList);
    }
}
