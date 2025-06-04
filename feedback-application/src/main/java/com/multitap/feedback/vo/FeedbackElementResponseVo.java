package com.multitap.feedback.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackElementResponseVo {

    private String elementName;
    private String elementContent;

    @Builder
    public FeedbackElementResponseVo(String elementName, String elementContent) {
        this.elementName = elementName;
        this.elementContent = elementContent;
    }

}
