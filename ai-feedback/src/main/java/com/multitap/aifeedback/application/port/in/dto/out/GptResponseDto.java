package com.multitap.aifeedback.application.port.in.dto.out;

import com.multitap.aifeedback.application.port.in.dto.in.GptRequestDto;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
public class GptResponseDto {

    private List<Choice> choices;

    @Builder
    public GptResponseDto(List<Choice> choices) {
        this.choices = choices;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Choice {
        private int index;
        private GptRequestDto.Message message;
    }
}
