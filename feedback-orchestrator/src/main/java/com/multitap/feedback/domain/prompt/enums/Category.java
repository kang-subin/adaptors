package com.multitap.feedback.domain.prompt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    RESUME("TC-CD7877C0"),
    COVER_LETTER("TC-8C93C5F5"),
    PORTFOLIO("TC-8E506504"),
    INTERVIEW("TC-0489394A");
    private final String value;
}
