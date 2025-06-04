package com.multitap.aifeedback.adaptor.in.mapper;

import com.multitap.aifeedback.application.port.in.dto.in.RetrievePromptRequestVo;
import org.springframework.stereotype.Component;

@Component
public class PromptVoMapper {

    public static RetrievePromptRequestVo from(String industryType, String documentType) {
        return RetrievePromptRequestVo.builder()
                .industryType(industryType)
                .documentType(documentType)
                .build();

    }

}
