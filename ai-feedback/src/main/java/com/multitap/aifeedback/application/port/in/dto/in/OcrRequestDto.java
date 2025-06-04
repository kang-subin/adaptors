package com.multitap.aifeedback.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
public class OcrRequestDto {

    private MultipartFile file;

    @Builder
    public OcrRequestDto(MultipartFile file) {
        this.file = file;
    }

}
