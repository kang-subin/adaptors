package com.multitap.feedback.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class FeedbackRequestVo {

    private String industry;
    private String documentType;
    private MultipartFile file;

    @Builder
    public FeedbackRequestVo(String industry, String documentType, MultipartFile file) {
        this.industry = industry;
        this.documentType = documentType;
        this.file = file;
    }
}