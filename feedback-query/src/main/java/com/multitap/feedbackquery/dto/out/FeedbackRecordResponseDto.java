package com.multitap.feedbackquery.dto.out;

import com.multitap.feedbackquery.dto.in.FeedbackScoreRequestDto;
import com.multitap.feedbackquery.vo.out.FeedbackRecordResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@NoArgsConstructor
public class FeedbackRecordResponseDto {

    private String mentorNickName;
    private String mentoringSessionUuid;
    private String mentoringDate;
    private String categoryCode;
    private Integer element1;
    private Integer element2;
    private Integer element3;
    private Integer element4;
    private Integer element5;
    private String content;

    @Builder
    public FeedbackRecordResponseDto(String mentorNickName, String mentoringSessionUuid, String mentoringDate, String categoryCode, Integer element1, Integer element2, Integer element3, Integer element4, Integer element5, String content) {
        this.mentorNickName = mentorNickName;
        this.mentoringSessionUuid = mentoringSessionUuid;
        this.mentoringDate = mentoringDate;
        this.categoryCode = categoryCode;
        this.element1 = element1;
        this.element2 = element2;
        this.element3 = element3;
        this.element4 = element4;
        this.element5 = element5;
        this.content = content;
    }

    public static FeedbackRecordResponseDto from(FeedbackScoreRequestDto feedbackScoreRequestDto) {
        return FeedbackRecordResponseDto.builder()
                .mentorNickName(feedbackScoreRequestDto.getMentorNickName())
                .mentoringSessionUuid(feedbackScoreRequestDto.getMentoringSessionUuid())
                .mentoringDate(formatDate(feedbackScoreRequestDto.getMentoringDate()))
                .categoryCode(feedbackScoreRequestDto.getCategoryCode())
                .element1(feedbackScoreRequestDto.getElement1())
                .element2(feedbackScoreRequestDto.getElement2())
                .element3(feedbackScoreRequestDto.getElement3())
                .element4(feedbackScoreRequestDto.getElement4())
                .element5(feedbackScoreRequestDto.getElement5())
                .content(feedbackScoreRequestDto.getContent())
                .build();
    }

    public static FeedbackRecordResponseVo toVo(FeedbackRecordResponseDto feedbackRecordResponseDto) {
        return FeedbackRecordResponseVo.builder()
                .mentorNickName(feedbackRecordResponseDto.getMentorNickName())
                .mentoringSessionUuid(feedbackRecordResponseDto.getMentoringSessionUuid())
                .mentoringDate(feedbackRecordResponseDto.getMentoringDate())
                .categoryCode(feedbackRecordResponseDto.getCategoryCode())
                .element1(feedbackRecordResponseDto.getElement1())
                .element2(feedbackRecordResponseDto.getElement2())
                .element3(feedbackRecordResponseDto.getElement3())
                .element4(feedbackRecordResponseDto.getElement4())
                .element5(feedbackRecordResponseDto.getElement5())
                .content(feedbackRecordResponseDto.getContent())
                .build();
    }

    private static String formatDate(LocalDateTime mentoringDate) {
        return mentoringDate != null ? mentoringDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null;
    }

}


