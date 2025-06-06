package com.multitap.feedback.application.prompt;

import com.multitap.feedback.common.exception.BaseException;
import com.multitap.feedback.common.response.BaseResponseStatus;
import com.multitap.feedback.domain.prompt.Prompt;
import com.multitap.feedback.dto.prompt.PromptRequestDto;
import com.multitap.feedback.dto.prompt.PromptResponseDto;
import com.multitap.feedback.infrastructure.repository.prompt.PromptRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class PromptServiceImpl implements PromptService {

    private final PromptRepository promptRepository;

    @Override
    public void addPrompt(PromptRequestDto promptRequestDto) {
        promptRepository.save(PromptRequestDto.toEntity(promptRequestDto));
    }

    @Override
    public String getPrompt(String industry, String documentType) {
        return promptRepository.findContentByIndustryAndDocumentType(industry, documentType)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PROMPT));
    }

    @Override
    public List<PromptResponseDto> getPromptList() {
        return promptRepository.findAll().stream()
                .map(PromptResponseDto::from)
                .toList();
    }

    @Override
    public void changePrompt(PromptRequestDto promptRequestDto, Long id) {
        Prompt prompt = promptRepository.findById(id).orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PROMPT));
        promptRepository.save(PromptRequestDto.updateToEntity(promptRequestDto, prompt));
    }


}
