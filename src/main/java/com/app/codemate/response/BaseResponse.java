package com.app.codemate.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import com.app.codemate.util.Constants;

@Getter
@Setter
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 134641874L;
    private Long serverTime = System.currentTimeMillis() / 1000;
    private String message;
    private String errorCode;
    private boolean success;

    public BaseResponse() {
        this.success = true;
        this.message = Constants.OK;
    }

    public BaseResponse(String message) {
        this.success = true;
        this.message = message;
    }

    public BaseResponse(String message, String errorCode) {
        this.success = false;
        this.message = message;
        this.errorCode = errorCode;
    }
}
