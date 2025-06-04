package com.multitap.aifeedback.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RetrievePromptRequestVo {

    private String industryType;
    private String documentType;

    @Builder
    public RetrievePromptRequestVo(String industryType, String documentType) {
        this.industryType = industryType;
        this.documentType = documentType;
    }
}
