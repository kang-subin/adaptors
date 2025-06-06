package com.multitap.aifeedback.application.port.in.dto.out;

import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackResponseDto {

    private String content;

    @Builder
    public FeedbackResponseDto(String content) {
        this.content = content;
    }

    public static FeedbackResponseDto of(String content) {
        return FeedbackResponseDto.builder()
                .content(content)
                .build();
    }

    public FeedbackResponseVo toVo() {
        return FeedbackResponseVo.builder()
                .content(content)
                .build();
    }
}
