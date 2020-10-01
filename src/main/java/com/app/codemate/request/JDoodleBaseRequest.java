package com.app.codemate.request;

import com.app.codemate.util.Constants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JDoodleBaseRequest {
    private String clientId = Constants.JDoodle.CLIENT_ID;
    private String clientSecret = Constants.JDoodle.CLIENT_SECRET;
}
