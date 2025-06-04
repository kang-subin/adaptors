package com.multitap.aifeedback.application.port.in.dto.in;

import com.multitap.aifeedback.adaptor.in.kafka.messagein.FeedbackScorePromptDto;
import com.multitap.aifeedback.adaptor.in.vo.TextRequestVo;
import com.multitap.aifeedback.adaptor.out.gpt.vo.AiFeedbackResponseVo;
import com.multitap.aifeedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CombinedPromptRequestDto {

    private Object request;
    private PromptDetailsResponseVo promptDetails;

    @Builder
    public CombinedPromptRequestDto(Object request, PromptDetailsResponseVo promptDetails) {
        this.request = request;
        this.promptDetails = promptDetails;
    }

    public static CombinedPromptRequestDto of(Object request, PromptDetailsResponseVo promptDetailsResponseVo) {
        return CombinedPromptRequestDto.builder()
                .request(request)
                .promptDetails(promptDetailsResponseVo)
                .build();
    }

    public static Object processResponse(Object request, String gptResponseContent) {
            if (request instanceof OcrProcessedFeedbackRequest || request instanceof TextRequestVo) {

                return AiFeedbackResponseVo.from(gptResponseContent);

            } else if (request instanceof FeedbackScorePromptDto.FeedbackScoreDto) {

                return gptResponseContent;

            } else {

                throw new IllegalArgumentException("Unsupported request type: " + request.getClass().getSimpleName());
            }
        }
}
