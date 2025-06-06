package com.multitap.feedback.dto.feedback;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AiResponseDto {

    String content;
    @Builder
    public AiResponseDto(String content) {
        this.content = content;
    }
}
