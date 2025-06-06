package com.multitap.feedback.vo.prompt;

import com.multitap.feedback.domain.prompt.enums.Category;
import com.multitap.feedback.domain.prompt.enums.DocumentType;
import com.multitap.feedback.domain.prompt.enums.IndustryType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PromptRequestVo {

    private IndustryType industry;
    private DocumentType documentType;
    private Category category;
    private String content;

    @Builder
    public PromptRequestVo(IndustryType industry, DocumentType documentType, Category category, String content) {
        this.industry = industry;
        this.documentType = documentType;
        this.category = category;
        this.content = content;

    }

}
