package com.multitap.feedback.domain.prompt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentType {
    RESUME("RESUME"),
    COVER_LETTER("COVER_LETTER"),
    PORTFOLIO("PORTFOLIO");
    private final String value;

}