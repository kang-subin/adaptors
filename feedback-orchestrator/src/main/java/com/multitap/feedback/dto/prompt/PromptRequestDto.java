package com.multitap.feedback.dto.prompt;

import com.multitap.feedback.domain.prompt.Prompt;
import com.multitap.feedback.domain.prompt.enums.Category;
import com.multitap.feedback.domain.prompt.enums.DocumentType;
import com.multitap.feedback.domain.prompt.enums.IndustryType;
import com.multitap.feedback.vo.prompt.PromptRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PromptRequestDto {

    private IndustryType industry;
    private DocumentType documentType;
    private Category category;
    private String content;

    @Builder
    public PromptRequestDto(IndustryType industry, DocumentType documentType,Category category, String content) {
        this.industry = industry;
        this.documentType = documentType;
        this.category = category;
        this.content = content;

    }

    public static PromptRequestDto from(PromptRequestVo promptRequestVo) {
        return PromptRequestDto.builder()
                .industry(promptRequestVo.getIndustry())
                .documentType(promptRequestVo.getDocumentType())
                .category(promptRequestVo.getCategory())
                .content(promptRequestVo.getContent())
                .build();
    }

    public static Prompt toEntity(PromptRequestDto promptRequestDto) {
        return Prompt.builder()
                .industry(promptRequestDto.getIndustry())
                .documentType(promptRequestDto.getDocumentType())
                .category(promptRequestDto.getCategory())
                .content(promptRequestDto.content)
                .build();
    }

    public static Prompt updateToEntity(PromptRequestDto promptRequestDto, Prompt prompt) {
        return Prompt.builder()
                .id(prompt.getId())
                .industry(promptRequestDto.getIndustry())
                .documentType(promptRequestDto.getDocumentType())
                .category(promptRequestDto.getCategory())
                .content(promptRequestDto.content)
                .build();
    }

}