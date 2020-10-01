package com.app.codemate.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JDoodleExecuteRequest extends JDoodleBaseRequest {
    private String script;
    private String language;
    private int versionIndex;
}
