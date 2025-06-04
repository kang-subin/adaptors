package com.multitap.feedback.dto;

import com.multitap.feedback.entity.FeedbackScore;
import com.multitap.feedback.vo.FeedbackScoreRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackScoreRequestDto {
    private String uuid;
    private String mentorNickName;
    private String mentoringSessionUuid;
    private String categoryCode;
    private Integer element1;
    private Integer element2;
    private Integer element3;
    private Integer element4;
    private Integer element5;
    private String content;

    @Builder
    public FeedbackScoreRequestDto(String uuid, String mentorNickName, String mentoringSessionUuid, String categoryCode, Integer element1, Integer element2, Integer element3, Integer element4, Integer element5, String content) {
        this.uuid = uuid;
        this.mentorNickName = mentorNickName;
        this.mentoringSessionUuid = mentoringSessionUuid;
        this.categoryCode = categoryCode;
        this.element1 = element1;
        this.element2 = element2;
        this.element3 = element3;
        this.element4 = element4;
        this.element5 = element5;
        this.content = content;
    }

    public static FeedbackScoreRequestDto from(FeedbackScoreRequestVo feedbackScoreRequestVo, String uuid) {
        return FeedbackScoreRequestDto.builder()
                .uuid(uuid)
                .mentorNickName(feedbackScoreRequestVo.getMentorNickName())
                .mentoringSessionUuid(feedbackScoreRequestVo.getMentoringSessionUuid())
                .categoryCode(feedbackScoreRequestVo.getCategoryCode())
                .element1(feedbackScoreRequestVo.getElements().getElement1())
                .element2(feedbackScoreRequestVo.getElements().getElement2())
                .element3(feedbackScoreRequestVo.getElements().getElement3())
                .element4(feedbackScoreRequestVo.getElements().getElement4())
                .element5(feedbackScoreRequestVo.getElements().getElement5())
                .content(feedbackScoreRequestVo.getContent())
                .build();
    }

    public FeedbackScore toEntity(FeedbackScoreRequestDto feedbackScoreRequestDto) {
        return FeedbackScore.builder()
                .uuid(feedbackScoreRequestDto.getUuid())
                .mentorNickName(feedbackScoreRequestDto.getMentorNickName())
                .mentoringSessionUuid(feedbackScoreRequestDto.getMentoringSessionUuid())
                .categoryCode(feedbackScoreRequestDto.getCategoryCode())
                .element1(feedbackScoreRequestDto.getElement1())
                .element2(feedbackScoreRequestDto.getElement2())
                .element3(feedbackScoreRequestDto.getElement3())
                .element4(feedbackScoreRequestDto.getElement4())
                .element5(feedbackScoreRequestDto.getElement5())
                .content(feedbackScoreRequestDto.getContent())
                .build();
    }


}
