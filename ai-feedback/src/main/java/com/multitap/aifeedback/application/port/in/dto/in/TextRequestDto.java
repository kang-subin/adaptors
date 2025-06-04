package com.multitap.aifeedback.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TextRequestDto {

    private String coverLetter;

    @Builder
    public TextRequestDto(String coverLetter) {
        this.coverLetter = coverLetter;
    }

}
