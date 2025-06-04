package com.multitap.feedbackquery.kafka.producer;

import com.multitap.feedbackquery.dto.out.FeedbackFirstLastScoreDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AiFeedbackScoreDto {

    private String uuid;
    private FeedbackFirstLastScoreDto.ElementScore firstScore;
    private FeedbackFirstLastScoreDto.ElementScore lastScore;
    private String categoryCode;

    @Builder
    public AiFeedbackScoreDto(String uuid, com.multitap.feedbackquery.dto.out.FeedbackFirstLastScoreDto.ElementScore firstScore, com.multitap.feedbackquery.dto.out.FeedbackFirstLastScoreDto.ElementScore lastScore, String categoryCode) {
        this.uuid = uuid;
        this.firstScore = firstScore;
        this.lastScore = lastScore;
        this.categoryCode = categoryCode;
    }

    public static AiFeedbackScoreDto from(FeedbackFirstLastScoreDto feedbackFirstLastScoreDto, String categoryCode) {
        return AiFeedbackScoreDto.builder()
                .uuid(feedbackFirstLastScoreDto.getId())
                .firstScore(feedbackFirstLastScoreDto.getFirstScore())
                .lastScore(feedbackFirstLastScoreDto.getLastScore())
                .categoryCode(categoryCode)
                .build();
    }
}
