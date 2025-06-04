package com.multitap.aifeedback.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;


@Getter
@NoArgsConstructor
public class OcrInputImageDto {
    private List<File> imageFiles;

    @Builder
    public OcrInputImageDto(List<File> imageFiles) {
        this.imageFiles = imageFiles;
    }

}
