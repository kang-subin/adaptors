package com.multitap.feedback.domain.prompt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IndustryType {
    MARKETING("MARKETING"),
    IT("IT"),
    PROJECT_MANAGEMENT("PROJECT_MANAGEMENT"),
    CONTENT_CREATION("CONTENT_CREATION"),
    EDUCATION("EDUCATION");
    private final String value;
}
