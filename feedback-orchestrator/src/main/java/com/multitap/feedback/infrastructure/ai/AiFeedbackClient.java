package com.multitap.feedback.infrastructure.ai;

import com.multitap.feedback.dto.feedback.FeedbackResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "ai-feedback", url = "http://localhost:8080")
public interface AiFeedbackClient {

    @PostMapping("")
    FeedbackResponseDto requestAiFeedback(@RequestBody String prompt, @RequestBody MultipartFile file);

}
