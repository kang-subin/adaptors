package com.multitap.aifeedback.adaptor.out.gpt.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackContentResponseVo {

    private String uuid;
    private String categoryCode;
    private Object content;

    @Builder
    public FeedbackContentResponseVo(String uuid, String categoryCode, Object content) {
        this.uuid = uuid;
        this.categoryCode = categoryCode;
        this.content = content;
    }

    public static FeedbackContentResponseVo from(String uuid, String categoryCode, Object content) {
        return FeedbackContentResponseVo.builder()
                .uuid(uuid)
                .categoryCode(categoryCode)
                .content(content)
                .build();
    }
}
