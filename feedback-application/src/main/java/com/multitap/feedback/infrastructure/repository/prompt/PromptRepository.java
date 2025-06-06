package com.multitap.feedback.infrastructure.repository.prompt;

import com.multitap.feedback.domain.prompt.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptRepository extends JpaRepository<Prompt, Long> {

}
