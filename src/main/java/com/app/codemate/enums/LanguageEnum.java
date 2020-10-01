package com.app.codemate.enums;

import lombok.Getter;

@Getter
public enum LanguageEnum {
    C("c"), CPP_14("cpp14"), CPP_17("cpp17"), JAVA("java"), PYTHON_3("python3");

    private final String value;

    LanguageEnum(String value) {
        this.value = value;
    }
}