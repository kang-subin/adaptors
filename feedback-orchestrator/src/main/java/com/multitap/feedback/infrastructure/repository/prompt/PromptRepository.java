package com.multitap.feedback.infrastructure.repository.prompt;

import com.multitap.feedback.domain.prompt.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PromptRepository extends JpaRepository<Prompt, Long> {
    @Query("SELECT p.content FROM Prompt p WHERE p.industry = :industry AND p.documentType = :documentType")
    Optional<String> findContentByIndustryAndDocumentType(String industry, String documentType);
}


