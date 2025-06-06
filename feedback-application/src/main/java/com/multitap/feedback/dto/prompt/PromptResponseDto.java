package com.multitap.feedback.dto.prompt;

import com.multitap.prompt.domain.Prompt;
import com.multitap.prompt.domain.PromptDetails;
import com.multitap.prompt.domain.enums.DocumentType;
import com.multitap.prompt.domain.enums.IndustryType;
import com.multitap.prompt.vo.out.PromptResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PromptResponseDto {

    private String id;
    private IndustryType industry;
    private DocumentType documentType;
    private PromptDetails promptDetails;

    @Builder
    public PromptResponseDto(String id, IndustryType industry, DocumentType documentType, PromptDetails promptDetails) {
        this.id = id;
        this.industry = industry;
        this.documentType = documentType;
        this.promptDetails = promptDetails;
    }

    public PromptResponseVo toVo() {
        return PromptResponseVo.builder()
                .id(id)
                .industry(industry)
                .documentType(documentType)
                .promptDetails(promptDetails)
                .build();
    }

    public static PromptResponseDto from(Prompt prompt){
        return PromptResponseDto.builder()
               .id(prompt.getId())
               .industry(prompt.getIndustry())
               .documentType(prompt.getDocumentType())
               .promptDetails(prompt.getPromptDetails())
               .build();
    }

}
