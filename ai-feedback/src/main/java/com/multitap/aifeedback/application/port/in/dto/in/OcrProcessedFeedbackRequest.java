package com.multitap.aifeedback.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OcrProcessedFeedbackRequest {

    private String content;

    @Builder
    public OcrProcessedFeedbackRequest(String content) {
        this.content = content;
    }

    public static OcrProcessedFeedbackRequest from(String content){
        return OcrProcessedFeedbackRequest.builder()
                .content(content)
                .build();
    }

}
