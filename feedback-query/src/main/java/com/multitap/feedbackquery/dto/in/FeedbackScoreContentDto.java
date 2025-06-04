package com.multitap.feedbackquery.dto.in;

import com.multitap.feedbackquery.entity.FeedbackRecord;
import com.multitap.feedbackquery.kafka.consumer.messagein.FeedbackContentResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackScoreContentDto {

    private String category;
    private Object content;

    @Builder
    public FeedbackScoreContentDto(String category, Object content) {
        this.category = category;
        this.content = content;
    }

    public static FeedbackScoreContentDto from(FeedbackContentResponseVo feedbackContentResponseVo) {
        return FeedbackScoreContentDto.builder()
                .category(feedbackContentResponseVo.getCategoryCode())
                .content(feedbackContentResponseVo.getContent())
                .build();
    }
}
