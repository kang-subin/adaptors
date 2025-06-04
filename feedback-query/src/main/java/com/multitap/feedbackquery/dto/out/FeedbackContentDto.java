package com.multitap.feedbackquery.dto.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackContentDto {

    private String content;

    @Builder
    public FeedbackContentDto(String content) {
        this.content = content;
    }
}
