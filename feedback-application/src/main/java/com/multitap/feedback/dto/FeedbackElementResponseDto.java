package com.multitap.feedback.dto;

import com.multitap.feedback.entity.FeedbackElement;
import com.multitap.feedback.vo.FeedbackElementResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackElementResponseDto {

    private String elementName;
    private String elementContent;

    @Builder
    public FeedbackElementResponseDto(String elementName, String elementContent) {
        this.elementName = elementName;
        this.elementContent = elementContent;
    }

    public static FeedbackElementResponseDto from(FeedbackElement feedbackElement){
        return FeedbackElementResponseDto.builder()
                .elementName(feedbackElement.getElementName())
                .elementContent(feedbackElement.getElementContent())
                .build();
    }

    public static FeedbackElementResponseVo toVo(FeedbackElementResponseDto feedbackElementResponseDto) {
        return FeedbackElementResponseVo.builder()
                .elementName(feedbackElementResponseDto.getElementName())
                .elementContent(feedbackElementResponseDto.getElementContent())
                .build();
    }
}
