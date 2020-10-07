package com.app.codemate.client;

import com.app.codemate.exception.ApiException;
import com.app.codemate.request.JDoodleBaseRequest;
import com.app.codemate.response.JDoodleCreditUseResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import com.app.codemate.request.JDoodleExecuteRequest;
import com.app.codemate.response.JDoodleExecuteResponse;
import com.app.codemate.util.Constants;

@Log4j2
@Component
public class JDoodleClient extends BaseClient {

    @Value("${jdoodle.server}")
    private String jdoodleServer;

    public JDoodleExecuteResponse execute(JDoodleExecuteRequest request) {
        String url = new StringBuilder(jdoodleServer).append(Constants.Http.V1).append(Constants.Http.EXECUTE).toString();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ParameterizedTypeReference<JDoodleExecuteResponse> typeReference = new ParameterizedTypeReference<JDoodleExecuteResponse>() {
        };
        log.info("jD exec: {}", request);
        try {
            JDoodleExecuteResponse response = exchange(HttpMethod.POST, url, httpHeaders, request, typeReference);
            log.info("jD resp: {}", response);
            return response;
        } catch (Exception e) {
            log.error("jD err: {}", e.getMessage());
            throw new ApiException(ApiException.ApiExceptionEnum.JDOODLE_FAILED);
        }
    }

    public JDoodleCreditUseResponse getCreditUsage(JDoodleBaseRequest request) {
        String url = new StringBuilder(jdoodleServer).append(Constants.Http.V1).append(Constants.Http.CREDIT_SPENT).toString();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ParameterizedTypeReference<JDoodleCreditUseResponse> typeReference = new ParameterizedTypeReference<JDoodleCreditUseResponse>() {
        };
        log.info("jD usage: {}", request);
        try {
            JDoodleCreditUseResponse response = exchange(HttpMethod.POST, url, httpHeaders, request, typeReference);
            log.info("jD resp: {}", response);
            return response;
        } catch (Exception e) {
            log.error("jD err: {}", e.getMessage());
            throw new ApiException(ApiException.ApiExceptionEnum.JDOODLE_FAILED);
        }
    }
}
