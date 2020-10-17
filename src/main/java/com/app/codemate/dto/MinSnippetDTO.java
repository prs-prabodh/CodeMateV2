package com.app.codemate.dto;

import com.app.codemate.enums.LanguageEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MinSnippetDTO {
    private String snippet;
    private LanguageEnum language;
    private String input;
    private String output;
}
