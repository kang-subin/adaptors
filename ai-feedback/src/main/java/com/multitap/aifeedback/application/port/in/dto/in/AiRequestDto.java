package com.multitap.aifeedback.application.port.in.dto.in;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
// prompt + pdf (OCR 처리 된 상태)
public class AiRequestDto {

    private String ocrResponse;
    private String prompt;

    @Builder
    public AiRequestDto(String ocrResponse, String prompt) {
        this.ocrResponse = ocrResponse;
        this.prompt = prompt;
    }

    public static AiRequestDto of(String ocrResponse, String prompt) {
        return AiRequestDto.builder()
                .ocrResponse(ocrResponse)
                .prompt(prompt)
                .build();
    }
}
