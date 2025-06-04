package com.multitap.aifeedback.adaptor.in.mapper;

import com.multitap.aifeedback.application.port.in.dto.in.OcrRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class OcrVoMapper {

    public static OcrRequestDto from(MultipartFile file) {
        return OcrRequestDto.builder()
                .file(file)
                .build();
    }

}
