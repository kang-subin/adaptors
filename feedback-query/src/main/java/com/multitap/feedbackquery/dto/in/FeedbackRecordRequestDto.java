package com.multitap.feedbackquery.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackRecordRequestDto {

    private String uuid;
    private String categoryCode;

    @Builder
    public FeedbackRecordRequestDto(String uuid, String categoryCode) {
        this.uuid = uuid;
        this.categoryCode = categoryCode;
    }

    public static FeedbackRecordRequestDto from(String uuid, String categoryCode) {
        return FeedbackRecordRequestDto.builder()
                .uuid(uuid)
                .categoryCode(categoryCode)
                .build();
    }

}
