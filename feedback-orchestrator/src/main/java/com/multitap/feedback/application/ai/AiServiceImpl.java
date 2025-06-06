package com.multitap.feedback.application.ai;

import com.multitap.feedback.dto.feedback.FeedbackResponseDto;
import com.multitap.feedback.infrastructure.ai.AiFeedbackClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AiService{

    private final AiFeedbackClient aiFeedbackClient;

    @Override
    public FeedbackResponseDto createAiFeedback(String prompt, MultipartFile file) {
        return aiFeedbackClient.requestAiFeedback(prompt, file);
    }
}
