package com.multitap.feedback.dto.prompt;

import com.multitap.feedback.domain.prompt.Prompt;
import com.multitap.feedback.vo.prompt.PromptRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PromptRequestDto {

    private String industry;
    private String documentType;
    private String category;
    private String content;

    @Builder
    public PromptRequestDto(String industry, String documentType, String category, String content) {
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