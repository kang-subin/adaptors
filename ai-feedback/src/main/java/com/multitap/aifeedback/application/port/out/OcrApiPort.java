package com.multitap.aifeedback.application.port.out;
import com.multitap.aifeedback.application.port.in.dto.in.OcrInputImageDto;
import com.multitap.aifeedback.application.port.in.dto.out.OcrResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface OcrApiPort {

    List<OcrResponseDto> callOcrApi(OcrInputImageDto ocrInputImageDto);
}