package com.multitap.feedback.dto.score;

import com.multitap.feedback.domain.score.Element;
import com.multitap.feedback.vo.score.ElementResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ElementResponseDto {

    private String elementName;
    private String elementContent;

    @Builder
    public ElementResponseDto(String elementName, String elementContent) {
        this.elementName = elementName;
        this.elementContent = elementContent;
    }

    public static ElementResponseDto from(Element feedbackElement){
        return ElementResponseDto.builder()
                .elementName(feedbackElement.getElementName())
                .elementContent(feedbackElement.getElementContent())
                .build();
    }

    public static ElementResponseVo toVo(ElementResponseDto elementResponseDto) {
        return ElementResponseVo.builder()
                .elementName(elementResponseDto.getElementName())
                .elementContent(elementResponseDto.getElementContent())
                .build();
    }
}
