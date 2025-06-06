package com.multitap.feedback.domain.prompt;

import com.multitap.feedback.common.response.BaseEntity;
import com.multitap.feedback.domain.prompt.enums.Category;
import com.multitap.feedback.domain.prompt.enums.DocumentType;
import com.multitap.feedback.domain.prompt.enums.IndustryType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Prompt extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private IndustryType industry;

    private DocumentType documentType;

    private Category category;

    private String content; // prompt 내용

    @Builder
    public Prompt(Long id, IndustryType industry, DocumentType documentType, Category category, String content) {
        this.id = id;
        this.industry = industry;
        this.documentType = documentType;
        this.category = category;
        this.content = content;
    }
}

