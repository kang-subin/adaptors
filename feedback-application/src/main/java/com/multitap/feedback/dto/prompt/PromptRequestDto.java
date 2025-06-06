package com.multitap.feedback.dto.prompt;

import com.multitap.prompt.domain.Prompt;
import com.multitap.prompt.domain.PromptDetails;
import com.multitap.prompt.domain.enums.Category;
import com.multitap.prompt.domain.enums.DocumentType;
import com.multitap.prompt.domain.enums.IndustryType;
import com.multitap.prompt.vo.in.PromptRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PromptRequestDto {

    private IndustryType industry;
    private DocumentType documentType;
    private Category category;
    private String replyFormat;
    private String request;

    @Builder
    public PromptRequestDto(IndustryType industry, DocumentType documentType,Category category, String replyFormat, String request) {
        this.industry = industry;
        this.documentType = documentType;
        this.category = category;
        this.replyFormat = replyFormat;
        this.request = request;

    }

    public static PromptRequestDto from(PromptRequestVo promptRequestVo) {
        return PromptRequestDto.builder()
                .industry(promptRequestVo.getIndustry())
                .documentType(promptRequestVo.getDocumentType())
                .category(promptRequestVo.getCategory())
                .replyFormat(promptRequestVo.getReplyFormat())
                .request(promptRequestVo.getRequest())
                .build();
    }

    public static Prompt toEntity(PromptRequestDto promptRequestDto) {
        return Prompt.builder()
                .industry(promptRequestDto.getIndustry())
                .documentType(promptRequestDto.getDocumentType())
                .category(promptRequestDto.getCategory())
                .promptDetails(PromptDetails.builder()
                        .replyFormat(promptRequestDto.replyFormat)
                        .request(promptRequestDto.request)
                        .build())
                .build();
    }

    public static Prompt updateToEntity(PromptRequestDto promptRequestDto, Prompt prompt) {
        return Prompt.builder()
                .id(prompt.getId())
                .industry(promptRequestDto.getIndustry())
                .documentType(promptRequestDto.getDocumentType())
                .category(promptRequestDto.getCategory())
                .promptDetails(PromptDetails.builder()
                        .replyFormat(promptRequestDto.replyFormat)
                        .request(promptRequestDto.request)
                        .build())
                .build();
    }

}