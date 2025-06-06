package com.multitap.feedback.application.ai;

import com.multitap.feedback.dto.feedback.FeedbackResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface AiService {
    FeedbackResponseDto createAiFeedback(String prompt, MultipartFile file);
}
