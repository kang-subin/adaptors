package com.multitap.feedback.vo;

import com.multitap.feedback.vo.prompt.PromptResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class FeedbackResponseVo {

    private String content;

}
