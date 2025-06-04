package com.multitap.aifeedback.adaptor.in.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class OcrRequestVo {

    private MultipartFile file;

    @Builder
    public OcrRequestVo(MultipartFile file) {
        this.file = file;
    }
}
