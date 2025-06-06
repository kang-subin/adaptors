package com.multitap.feedback.presentation.prompt;

import com.multitap.feedback.application.prompt.PromptService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "프롬프트 API", description = "프롬프트 CRUD API endpoints")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/prompt")
public class PromptController {

    private final PromptService promptService;


}
