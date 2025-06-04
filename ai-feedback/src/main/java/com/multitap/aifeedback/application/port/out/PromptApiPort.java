package com.multitap.aifeedback.application.port.out;

import com.multitap.aifeedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.aifeedback.application.port.in.dto.in.RetrievePromptRequestVo;
import org.springframework.stereotype.Component;

@Component
public interface PromptApiPort {

    PromptDetailsResponseVo callPromptApi(RetrievePromptRequestVo retrievePromptRequestVo);

}
