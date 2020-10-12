package com.app.codemate.request;

import com.app.codemate.enums.LanguageEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class SnippetExecuteRequest {

    private String script;

    @NotNull
    private LanguageEnum language;

    private String stdin;
}
