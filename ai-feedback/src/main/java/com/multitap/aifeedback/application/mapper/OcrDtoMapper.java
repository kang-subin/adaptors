package com.multitap.aifeedback.application.mapper;

import com.multitap.aifeedback.application.port.in.dto.in.OcrInputImageDto;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class OcrDtoMapper {
    public static OcrInputImageDto from(List<File> imageFiles) {
        return OcrInputImageDto.builder()
                .imageFiles(imageFiles)
                .build();
    }

}
