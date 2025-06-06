package com.multitap.feedback.dto.prompt;

import com.multitap.feedback.domain.prompt.Prompt;
import com.multitap.feedback.vo.prompt.PromptResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PromptResponseDto {

    private Long id;
    private String industry;
    private String documentType;
    private String category;
    private String content;

    @Builder
    public PromptResponseDto(Long id, String industry, String documentType, String category, String content) {
        this.id = id;
        this.industry = industry;
        this.documentType = documentType;
        this.category = category;
        this.content = content;
    }

    public PromptResponseVo toVo() {
        return PromptResponseVo.builder()
                .id(id)
                .industry(industry)
                .documentType(documentType)
                .category(category)
                .content(content)
                .build();
    }

    public static PromptResponseDto from(Prompt prompt) {
        return PromptResponseDto.builder()
                .id(prompt.getId())
                .industry(prompt.getIndustry())
                .documentType(prompt.getDocumentType())
                .category(prompt.getCategory())
                .content(prompt.getContent())
                .build();
    }

}
