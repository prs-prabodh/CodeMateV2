package com.app.codemate.service;

import com.app.codemate.client.JDoodleClient;
import com.app.codemate.converter.SnippetConverter;
import com.app.codemate.request.JDoodleBaseRequest;
import com.app.codemate.response.JDoodleCreditUseResponse;
import com.app.codemate.util.Constants;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.codemate.request.JDoodleExecuteRequest;
import com.app.codemate.request.SnippetExecuteRequest;
import com.app.codemate.response.JDoodleExecuteResponse;
import com.app.codemate.response.SnippetExecuteResponse;

@Service
public class SnippetService {

    @Autowired
    private JDoodleClient jDoodleClient;

    public SnippetExecuteResponse execute(SnippetExecuteRequest request) {
        JDoodleExecuteRequest jDoodleExecuteRequest = SnippetConverter.convertToJDoodleExecuteRequest(request);
        JDoodleExecuteResponse jDoodleExecuteResponse = jDoodleClient.execute(jDoodleExecuteRequest);
        return SnippetConverter.convertToSnippetExecuteResponse(jDoodleExecuteResponse);
    }

    public Boolean executeLimitReached() {
        JDoodleBaseRequest jDoodleBaseRequest = new JDoodleBaseRequest();
        JDoodleCreditUseResponse jDoodleCreditUseResponse = jDoodleClient.getCreditUsage(jDoodleBaseRequest);
        return ObjectUtils.allNotNull(jDoodleCreditUseResponse.getUsed()) && BooleanUtils.isTrue(Constants.JDoodle.CREDIT_LIMIT_PER_DAY <= jDoodleCreditUseResponse.getUsed());
    }
}
