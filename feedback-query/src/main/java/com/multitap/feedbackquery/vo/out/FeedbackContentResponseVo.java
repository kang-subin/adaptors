package com.multitap.feedbackquery.vo.out;

import com.multitap.feedbackquery.dto.out.FeedbackFirstLastScoreDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackContentResponseVo {

    private FeedbackFirstLastScoreDto feedbackFirstLastScoreDto;
    private String feedbackContent;

    @Builder
    public FeedbackContentResponseVo(FeedbackFirstLastScoreDto feedbackFirstLastScoreDto, String feedbackContent) {
        this.feedbackFirstLastScoreDto = feedbackFirstLastScoreDto;
        this.feedbackContent = feedbackContent;
    }
}
