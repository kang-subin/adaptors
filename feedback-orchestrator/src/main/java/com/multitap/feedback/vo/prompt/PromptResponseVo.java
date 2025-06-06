package com.multitap.feedback.vo.prompt;

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
    private String industry;
    private String documentType;
    private String category;
    private String content;

}
