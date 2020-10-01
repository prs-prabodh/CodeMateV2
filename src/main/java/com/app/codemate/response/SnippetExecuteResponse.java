package com.app.codemate.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SnippetExecuteResponse {
    private String output;
    private String memory;
    private String cpuTime;
    private String error;
}
