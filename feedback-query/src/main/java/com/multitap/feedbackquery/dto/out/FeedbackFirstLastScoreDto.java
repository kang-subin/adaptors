package com.multitap.feedbackquery.dto.out;

import com.multitap.feedbackquery.vo.out.FeedbackFirstLastScoreResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackFirstLastScoreDto {

    private String id;
    private ElementScore firstScore;
    private ElementScore lastScore;

    @Builder
    public FeedbackFirstLastScoreDto(String id, ElementScore firstScore, ElementScore lastScore) {
        this.id = id;
        this.firstScore = firstScore;
        this.lastScore = lastScore;

    }

    public static FeedbackFirstLastScoreResponseVo toVo(FeedbackFirstLastScoreDto dto) {
        return FeedbackFirstLastScoreResponseVo.builder()
                .firstScore(dto.getFirstScore())
                .lastScore(dto.getLastScore())
                .build();
    }

    @Getter
    @NoArgsConstructor
    public static class ElementScore {

        private Integer element1;
        private Integer element2;
        private Integer element3;
        private Integer element4;
        private Integer element5;
        private String mentoringDate;

        @Builder
        public ElementScore(Integer element1, Integer element2, Integer element3, Integer element4, Integer element5, String mentoringDate) {
            this.element1 = element1;
            this.element2 = element2;
            this.element3 = element3;
            this.element4 = element4;
            this.element5 = element5;
            this.mentoringDate = mentoringDate;
        }
    }
}
