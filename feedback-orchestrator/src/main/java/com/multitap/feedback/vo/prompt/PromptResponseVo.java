package com.multitap.feedback.vo.prompt;

import com.multitap.feedback.domain.prompt.enums.Category;
import com.multitap.feedback.domain.prompt.enums.DocumentType;
import com.multitap.feedback.domain.prompt.enums.IndustryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PromptResponseVo {

    private Long id;
    private IndustryType industry;
    private DocumentType documentType;
    private Category category;
    private String content;

}
