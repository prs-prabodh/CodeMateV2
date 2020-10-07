package com.app.codemate.exception.handler;

import com.app.codemate.exception.ApiException;
import com.app.codemate.response.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Log4j2
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ApiException.class })
    protected Response<?> apiExceptionHandler(ApiException e) {
        log.error("err: {}", e.getMessage());
        if (e.getApiExceptionEnum() != null) {
            return new Response<>(e.getApiExceptionEnum().getErrorCode(), e.getApiExceptionEnum().getErrorMessage());
        }
        return new Response<>("400", "Bad Request");
    }

    @ExceptionHandler(value = { Exception.class })
    protected Response<?> globalExceptionHandler(Exception e) {
        return new Response<>("500", e.getMessage());
    }
}
