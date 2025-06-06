package com.multitap.feedback.domain.prompt;

import com.multitap.feedback.common.response.BaseEntity;
import jakarta.persistence.*;
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

    private String industry;

    private String documentType;

    private String category;

    @Lob
    private String content; // prompt 내용

    @Builder
    public Prompt(Long id, String industry, String documentType, String category, String content) {
        this.id = id;
        this.industry = industry;
        this.documentType = documentType;
        this.category = category;
        this.content = content;
    }
}

