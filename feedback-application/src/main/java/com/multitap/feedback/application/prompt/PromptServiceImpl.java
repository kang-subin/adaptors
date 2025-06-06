package com.multitap.feedback.application.prompt;

import com.multitap.feedback.dto.prompt.PromptRequestDto;
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
    public void addContentPrompt(ContentPromptRequestDto contentPromptRequestDto) {
        promptRepository.save(contentPromptRequestDto.toEntity(contentPromptRequestDto));
    }

    @Override
    public List<PromptResponseDto> getPromptList() {
        return promptRepository.findAll().stream()
                .map(PromptResponseDto::from)
                .toList();
    }

    @Override
    public void changePrompt(PromptRequestDto promptRequestDto, String id) {
       Prompt prompt =  promptRepository.findById(id).orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PROMPT));
       promptRepository.save(PromptRequestDto.updateToEntity(promptRequestDto,prompt));
    }

    @Override
    public PromptDetailsResponseDto searchPromptDetails(RetrievePromptRequestDto retrievePromptRequestDto) {
        Prompt prompt = promptRepository.findByIndustryAndDocumentType(retrievePromptRequestDto.getIndustryType(),retrievePromptRequestDto.getDocumentType())
                .orElseThrow(()-> new BaseException(BaseResponseStatus.NO_EXIST_PROMPT));

        log.info("프롬프트 전달 값:{},{}",prompt.getPromptDetails().getReplyFormat(),prompt.getPromptDetails().getRequest());
        return PromptDetailsResponseDto.from(prompt);
    }

}
