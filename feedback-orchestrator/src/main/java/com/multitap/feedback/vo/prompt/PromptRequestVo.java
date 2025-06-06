package com.multitap.feedback.vo.prompt;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PromptRequestVo {

    private String industry;
    private String documentType;
    private String category;
    private String content;

    @Builder
    public PromptRequestVo(String industry, String documentType, String category, String content) {
        this.industry = industry;
        this.documentType = documentType;
        this.category = category;
        this.content = content;

    }

}
