package com.app.codemate.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JDoodleBaseRequest {
    private String clientId = System.getenv("JDOODLE_CLIENT_ID");
    private String clientSecret = System.getenv("JDOODLE_CLIENT_SECRET");
}
