package com.multitap.feedbackquery.presentation;

import com.multitap.feedbackquery.application.FeedbackRecordService;
import com.multitap.feedbackquery.common.response.BaseResponse;
import com.multitap.feedbackquery.dto.in.FeedbackRecordRequestDto;
import com.multitap.feedbackquery.dto.out.FeedbackContentResponseDto;
import com.multitap.feedbackquery.dto.out.FeedbackRecordResponseDto;
import com.multitap.feedbackquery.vo.out.FeedbackContentResponseVo;
import com.multitap.feedbackquery.vo.out.FeedbackRecordResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "피드백 조회 API", description = "피드백, AI 피드백 조회 관련 API endpoints")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/feedback-record")
public class FeedbackRecordController {

    private final FeedbackRecordService feedbackRecordService;

    @Operation(summary = "피드백 점수 조회", description = "카테고리별 피드백 점수를 조회합니다.")
    @GetMapping("/feedback-score/{categoryCode}")
    public BaseResponse<List<FeedbackRecordResponseVo>> getFeedbackScore(@RequestHeader("userUuid") String uuid, @PathVariable String categoryCode) {
        List<FeedbackRecordResponseVo> feedbackRecordResponseVoList = feedbackRecordService.getFeedbackScore(FeedbackRecordRequestDto.from(uuid, categoryCode))
                .stream()
                .map(FeedbackRecordResponseDto::toVo)
                .toList();
        return new BaseResponse<>(feedbackRecordResponseVoList);
    }

    @Operation(summary = "피드백 그래프 값, 볼팡이 코멘트 조회", description = "카테고리별 피드백 첫 점수와 최근 마지막 점수와 볼팡이 코멘트를 조회합니다.")
    @GetMapping("/feedback-graph/{categoryCode}")
    public BaseResponse<FeedbackContentResponseVo> getFeedbackGraph(@RequestHeader("userUuid") String uuid, @PathVariable String categoryCode) {
        FeedbackContentResponseDto feedbackContentResponseDto = feedbackRecordService.getFeedbackFirstLastScoreAndContent(FeedbackRecordRequestDto.from(uuid, categoryCode));
        return new BaseResponse<>(feedbackContentResponseDto.toVo());
    }
}
