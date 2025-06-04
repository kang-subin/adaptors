package com.multitap.aifeedback.adaptor.out.prompt.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromptDetailsResponseVo {

    private String replyFormat;

    private String request;

}
