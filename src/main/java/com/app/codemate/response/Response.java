package com.app.codemate.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response <T> extends BaseResponse {
    private T data;

    public Response() {}

    public Response(String errorCode, String errorMessage) {
        this.setErrorCode(errorCode);
        this.setMessage(errorMessage);
        this.setSuccess(false);
    }

    public Response(T data) {
        this.data = data;
    }
}
