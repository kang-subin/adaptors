package com.multitap.feedback.dto.feedback;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class FeedbackRequestDto {

    private String industry;
    private String documentType;
    private MultipartFile file;

    @Builder
    public FeedbackRequestDto(String industry, String documentType, MultipartFile file) {
        this.industry = industry;
        this.documentType = documentType;
        this.file = file;
    }
}