package com.multitap.aifeedback.adaptor.out.ocr.presentation;

import com.multitap.aifeedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.aifeedback.application.port.in.dto.out.OcrResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
//todo:이 아이는 어느 패키지에 소속되어야 하는지 궁금합니다!
public class OcrProcessingService {

    private static final int Y_THRESHOLD = 10; // 같은 줄로 인식할 Y좌표 차이 임계값
    private static final double CONFIDENCE_THRESHOLD = 0.7; // 신뢰도 임계값


    public OcrProcessedFeedbackRequest parseOcrResponses(List<OcrResponseDto> responses) {
        String combinedText = responses.stream()
                .flatMap(response -> response.getImages().stream())
                .map(this::parseSingleImage)
                .collect(Collectors.joining("\n"));

        return OcrProcessedFeedbackRequest.from(combinedText);
    }

    private String parseSingleImage(OcrResponseDto.Image image) {
        List<OcrResponseDto.Field> validFields = filterValidFields(image.getFields());
        return combineFields(validFields);
    }

    private List<OcrResponseDto.Field> filterValidFields(List<OcrResponseDto.Field> fields) {
        return fields.stream()
                .filter(field -> field.getInferConfidence() >= 0.85)  // 예시로 Confidence Threshold 적용
                .collect(Collectors.toList());
    }

    private String combineFields(List<OcrResponseDto.Field> fields) {
        return fields.stream()
                .sorted(Comparator.comparingDouble(f -> f.getBoundingPoly().getVertices().get(0).getX()))
                .map(OcrResponseDto.Field::getInferText)
                .collect(Collectors.joining(" "));
    }
    

}



