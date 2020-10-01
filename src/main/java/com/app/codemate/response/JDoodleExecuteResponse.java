package com.app.codemate.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JDoodleExecuteResponse {
    private String output;
    private String statusCode;
    private String memory;
    private String cpuTime;
    private String error;
}
