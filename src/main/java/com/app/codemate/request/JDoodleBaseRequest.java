package com.app.codemate.request;

import com.app.codemate.util.Constants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JDoodleBaseRequest {
    private String clientId = System.getenv("jdoodle.clientId");
    private String clientSecret = System.getenv("jdoodle.clientSecret");
}
