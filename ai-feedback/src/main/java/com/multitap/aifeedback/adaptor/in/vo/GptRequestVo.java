package com.multitap.aifeedback.adaptor.in.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GptRequestVo {

    private String prompt;

    @Builder
    public GptRequestVo(String prompt) {
        this.prompt = prompt;
    }

    public static GptRequestVo from(String prompt) {
        return GptRequestVo.builder()
                .prompt(prompt)
                .build();
    }
}
