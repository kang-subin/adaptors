package com.multitap.aifeedback.application.port.in.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OcrResponseDto {
    private String version;
    private String requestId;
    private long timestamp;
    private List<Image> images;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Image {
        private String uid;
        private String name;
        private String inferResult;
        private String message;
        private ValidationResult validationResult;
        private List<Field> fields;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ValidationResult {
        private String result;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Field {
        private String valueType;
        private BoundingPoly boundingPoly;
        private String inferText;
        private double inferConfidence;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BoundingPoly {
        private List<Vertex> vertices;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Vertex {
        private double x;
        private double y;
    }
}