package com.multitap.feedback.dto.score;

import com.multitap.feedback.domain.score.Score;
import com.multitap.feedback.vo.score.ScoreRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScoreRequestDto {
    private String uuid;
    private String mentorNickName;
    private String mentoringSessionUuid;
    private String categoryCode; // 면접, 이력서, 자소서, 포트폴리오
    private Integer element1;
    private Integer element2;
    private Integer element3;
    private Integer element4;
    private Integer element5;
    private String content;

    @Builder
    public ScoreRequestDto(String uuid, String mentorNickName, String mentoringSessionUuid, String categoryCode, Integer element1, Integer element2, Integer element3, Integer element4, Integer element5, String content) {
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

    public static ScoreRequestDto from(ScoreRequestVo scoreRequestVo, String uuid) {
        return ScoreRequestDto.builder()
                .uuid(uuid)
                .mentorNickName(scoreRequestVo.getMentorNickName())
                .mentoringSessionUuid(scoreRequestVo.getMentoringSessionUuid())
                .categoryCode(scoreRequestVo.getCategoryCode())
                .element1(scoreRequestVo.getElements().getElement1())
                .element2(scoreRequestVo.getElements().getElement2())
                .element3(scoreRequestVo.getElements().getElement3())
                .element4(scoreRequestVo.getElements().getElement4())
                .element5(scoreRequestVo.getElements().getElement5())
                .content(scoreRequestVo.getContent())
                .build();
    }

    public Score toEntity(ScoreRequestDto scoreRequestDto) {
        return Score.builder()
                .uuid(scoreRequestDto.getUuid())
                .mentorNickName(scoreRequestDto.getMentorNickName())
                .mentoringSessionUuid(scoreRequestDto.getMentoringSessionUuid())
                .categoryCode(scoreRequestDto.getCategoryCode())
                .element1(scoreRequestDto.getElement1())
                .element2(scoreRequestDto.getElement2())
                .element3(scoreRequestDto.getElement3())
                .element4(scoreRequestDto.getElement4())
                .element5(scoreRequestDto.getElement5())
                .content(scoreRequestDto.getContent())
                .build();
    }


}
