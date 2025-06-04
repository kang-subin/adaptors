package com.multitap.aifeedback.application.port.in;

import com.multitap.aifeedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.aifeedback.application.port.in.dto.in.OcrRequestDto;

import java.io.IOException;

public interface OcrUseCase {
    OcrProcessedFeedbackRequest uploadPdfForOcr (OcrRequestDto ocrRequestDto) throws IOException;
}
