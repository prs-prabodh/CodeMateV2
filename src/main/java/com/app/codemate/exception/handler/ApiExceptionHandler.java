package com.app.codemate.exception.handler;

import com.app.codemate.exception.ApiException;
import com.app.codemate.response.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Log4j2
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ApiException.class })
    protected ResponseEntity<Response<Object>> apiExceptionHandler(ApiException e) {
        log.error("err: {}", e.getMessage());
        if (e.getApiExceptionEnum() != null) {
            return new ResponseEntity<>(new Response<>(e.getApiExceptionEnum().getErrorCode(), e.getApiExceptionEnum().getErrorMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Response<>("400", "Bad Request"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<?> globalExceptionHandler(Exception e) {
        return new ResponseEntity<>(new Response<>("500", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
