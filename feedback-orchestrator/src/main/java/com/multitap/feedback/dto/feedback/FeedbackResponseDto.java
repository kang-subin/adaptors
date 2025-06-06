package com.multitap.feedback.dto.feedback;

import com.multitap.feedback.vo.FeedbackResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackResponseDto {

    String content;

    @Builder
    public FeedbackResponseDto(String content) {
        this.content = content;
    }

    public FeedbackResponseDto from(AiResponseDto aiResponseDto) {
        return FeedbackResponseDto.builder()
                .content(aiResponseDto.getContent())
                .build();
    }

    public FeedbackResponseVo toVo() {
        return FeedbackResponseVo.builder()
                .content(content)
                .build();
    }

}
