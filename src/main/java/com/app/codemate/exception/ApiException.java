package com.app.codemate.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException {

    private ApiExceptionEnum apiExceptionEnum;

    public ApiException(ApiExceptionEnum apiExceptionEnum) {
        this.apiExceptionEnum = apiExceptionEnum;
    }

    @Getter
    public enum ApiExceptionEnum {

        SNIPPET_NOT_FOUND("400", "Snippet not found"),
        JDOODLE_FAILED("500", "JDoodle Server Error");

        private final String errorCode;
        private final String errorMessage;

        ApiExceptionEnum(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }
    }

}
