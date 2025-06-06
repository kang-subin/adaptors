package com.multitap.feedback.vo.feedback;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ElementResponseVo {

    private String elementName;
    private String elementContent;

    @Builder
    public ElementResponseVo(String elementName, String elementContent) {
        this.elementName = elementName;
        this.elementContent = elementContent;
    }

}
