package com.app.codemate.enums;

import lombok.Getter;

@Getter
public enum LanguageEnum {
    C("c"), CPP_14("cpp14"), CPP_17("cpp17"), JAVA("java"), PYTHON_3("python3"), C_SHARP("csharp"), RUBY("ruby"), RUST("rust"), GO_LANG("go"), PYTHON_2_7("python2"), KOTLIN("kotlin"), NODE_JS("nodejs");

    private final String value;

    LanguageEnum(String value) {
        this.value = value;
    }
}