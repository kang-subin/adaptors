package com.multitap.aifeedback.application.port.in;
import com.multitap.aifeedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.aifeedback.application.port.in.dto.in.RetrievePromptRequestVo;

public interface PromptUseCase {

    PromptDetailsResponseVo sendRequestPrompt (RetrievePromptRequestVo retrievePromptRequestVo);
}
