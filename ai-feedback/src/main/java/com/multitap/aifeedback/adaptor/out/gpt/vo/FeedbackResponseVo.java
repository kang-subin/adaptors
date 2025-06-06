package com.multitap.aifeedback.adaptor.out.gpt.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@NoArgsConstructor
public class FeedbackResponseVo {

    private String content;
    @Builder
    public FeedbackResponseVo(String content) {
        this.content = content;
    }
}