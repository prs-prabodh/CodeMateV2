package com.app.codemate.client;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class BaseClient {
    RestTemplate restTemplate = new RestTemplate();

    public <T> T exchange(HttpMethod httpMethod, String url, HttpHeaders headers, Object request, ParameterizedTypeReference<T> responseType) {
        return restTemplate.exchange(url, httpMethod, new HttpEntity<>(request, headers), responseType).getBody();
    }
}
