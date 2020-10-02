package com.app.codemate.request;

import com.app.codemate.enums.LanguageEnum;
import com.app.codemate.enums.VersionEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class SnippetSaveRequest {

    @NotNull
    private String snippet;

    @NotNull
    private LanguageEnum language;

    @NotNull
    private VersionEnum version;
}
