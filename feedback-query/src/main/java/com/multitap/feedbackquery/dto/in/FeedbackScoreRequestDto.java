package com.multitap.feedbackquery.dto.in;

import com.multitap.feedbackquery.entity.FeedbackRecord;
import com.multitap.feedbackquery.kafka.consumer.messagein.FeedbackScoreDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.ArrayList;


@Getter
@NoArgsConstructor
public class FeedbackScoreRequestDto {
    private String mentorNickName;
    private String mentoringSessionUuid;
    private LocalDateTime mentoringDate;

    @Indexed
    private String categoryCode;

    private Integer element1;
    private Integer element2;
    private Integer element3;
    private Integer element4;
    private Integer element5;
    private String content;


    @Builder
    public FeedbackScoreRequestDto(String mentorNickName, String mentoringSessionUuid, LocalDateTime mentoringDate, String categoryCode, Integer element1, Integer element2, Integer element3, Integer element4, Integer element5, String content) {
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

    public static FeedbackScoreRequestDto from(FeedbackScoreDto feedbackScoreDto) {
        return FeedbackScoreRequestDto.builder()
                .mentorNickName(feedbackScoreDto.getMentorNickName())
                .mentoringSessionUuid(feedbackScoreDto.getMentoringSessionUuid())
                .mentoringDate(feedbackScoreDto.getMentoringDate())
                .categoryCode(feedbackScoreDto.getCategoryCode())
                .element1(feedbackScoreDto.getElement1())
                .element2(feedbackScoreDto.getElement2())
                .element3(feedbackScoreDto.getElement3())
                .element4(feedbackScoreDto.getElement4())
                .element5(feedbackScoreDto.getElement5())
                .content(feedbackScoreDto.getContent())
                .build();
    }

    public FeedbackRecord toEntity(FeedbackScoreRequestDto feedbackScoreRequestDto, String uuid) {
        FeedbackRecord feedbackRecord = FeedbackRecord.builder()
                .id(uuid)
                .feedbackScore(new ArrayList<>())
                .build();

        feedbackRecord.getFeedbackScore().add(feedbackScoreRequestDto);
        return feedbackRecord;
    }

    public FeedbackRecord updateToEntity(FeedbackScoreRequestDto feedbackScoreRequestDto, FeedbackRecord feedbackRecord) {
        feedbackRecord.getFeedbackScore().add(feedbackScoreRequestDto);
        return FeedbackRecord.builder()
                .id(feedbackRecord.getId())
                .feedbackScore(feedbackRecord.getFeedbackScore())
                .build();
    }
}

