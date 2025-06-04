package com.multitap.aifeedback.adaptor.out.gpt.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@NoArgsConstructor
public class AiFeedbackResponseVo {

    private String improvements;
    private String strengths;

    @Builder
    public AiFeedbackResponseVo(String improvements, String strengths) {
        this.improvements = improvements;
        this.strengths = strengths;
    }

    public static AiFeedbackResponseVo from(String content) {
        try {
            if (content == null || content.trim().isEmpty()) {
                return createEmptyResponse();
            }

            // 문자열 정규화: 여러 줄바꿈을 단일 줄바꿈으로 변환
            content = content.replaceAll("\\n+", "\n").trim();

            // 개선할 점과 장점 섹션 추출
            String improvements = extractSection(content, "개선할 점", "장점");
            String strengths = extractSection(content, "장점", null);

            return AiFeedbackResponseVo.builder()
                    .improvements(improvements)
                    .strengths(strengths)
                    .build();
        } catch (Exception e) {
            return createEmptyResponse();
        }
    }

    private static String extractSection(String content, String startMarker, String endMarker) {
        try {
            // 1. 섹션 구분을 위한 정규식 활용
            Pattern pattern;
            if (endMarker == null) {
                pattern = Pattern.compile(startMarker + ":(.*)", Pattern.DOTALL);
            } else {
                pattern = Pattern.compile(startMarker + ":(.*)" + endMarker + ":", Pattern.DOTALL);
            }

            Matcher matcher = pattern.matcher(content);
            if (matcher.find()) {
                return cleanText(matcher.group(1));
            }
        } catch (Exception e) {
            // 에러 발생 시 빈 문자열 반환
        }
        return "";
    }

    private static String cleanText(String text) {
        return text.replaceAll("(?m)^\\s*-\\s*", "") // 불렛 포인트 제거
                .replaceAll("\\n\\s*", " ") // 줄바꿈 제거
                .replaceAll("\\s+", " ") // 연속된 공백 제거
                .trim();
    }

    private static AiFeedbackResponseVo createEmptyResponse() {
        return AiFeedbackResponseVo.builder()
                .improvements("")
                .strengths("")
                .build();
    }

}