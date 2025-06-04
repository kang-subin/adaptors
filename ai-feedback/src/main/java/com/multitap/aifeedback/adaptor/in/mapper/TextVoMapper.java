package com.multitap.aifeedback.adaptor.in.mapper;

import com.multitap.aifeedback.adaptor.in.vo.TextRequestVo;
import com.multitap.aifeedback.application.port.in.dto.in.TextRequestDto;

public class TextVoMapper {

    public static TextRequestDto from(TextRequestVo textRequestVo){
        return TextRequestDto.builder()
                .coverLetter(textRequestVo.getCoverLetter())
                .build();
    }
}
