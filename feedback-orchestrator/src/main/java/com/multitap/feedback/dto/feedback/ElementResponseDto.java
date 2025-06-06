package com.multitap.feedback.dto.feedback;

import com.multitap.feedback.domain.feedback.Element;
import com.multitap.feedback.vo.feedback.ElementResponseVo;
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
