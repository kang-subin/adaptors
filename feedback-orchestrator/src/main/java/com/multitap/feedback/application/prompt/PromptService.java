package com.multitap.feedback.application.prompt;

import com.multitap.feedback.dto.prompt.PromptRequestDto;
import com.multitap.feedback.dto.prompt.PromptResponseDto;

import java.util.List;

public interface PromptService {
    void addPrompt(PromptRequestDto promptRequestDto);

    String getPrompt(String industry, String documentType);

    List<PromptResponseDto> getPromptList();

    void changePrompt(PromptRequestDto promptRequestDto, Long id);
}
