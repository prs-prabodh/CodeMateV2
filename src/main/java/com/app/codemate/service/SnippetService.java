package com.app.codemate.service;

import com.app.codemate.client.JDoodleClient;
import com.app.codemate.converter.SnippetConverter;
import com.app.codemate.dto.MinSnippetDTO;
import com.app.codemate.exception.ApiException;
import com.app.codemate.model.SnippetModel;
import com.app.codemate.repository.SnippetRepository;
import com.app.codemate.request.JDoodleBaseRequest;
import com.app.codemate.request.SnippetSaveRequest;
import com.app.codemate.response.JDoodleCreditUseResponse;
import com.app.codemate.response.SnippetSaveResponse;
import com.app.codemate.service.helper.SnippetHelperService;
import com.app.codemate.util.Constants;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.codemate.request.JDoodleExecuteRequest;
import com.app.codemate.request.SnippetExecuteRequest;
import com.app.codemate.response.JDoodleExecuteResponse;
import com.app.codemate.response.SnippetExecuteResponse;

@Log4j2
@Service
public class SnippetService {

    @Autowired
    private JDoodleClient jDoodleClient;

    @Autowired
    private SnippetRepository snippetRepository;

    @Autowired
    private SnippetHelperService snippetHelperService;

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


    public SnippetSaveResponse save(SnippetSaveRequest request) {
        SnippetModel snippet = SnippetConverter.convertToSnippetModel(request, snippetHelperService.generateValidUid());
        snippetRepository.save(snippet);
        return SnippetConverter.convertToSnippetSaveResponse(snippet);
    }

    public MinSnippetDTO getSnippet(String uid) {
        SnippetModel snippet = snippetRepository.findByUid(uid);
        if (snippet == null) {
            log.error("snippet not found, uid: {}", uid);
            throw new ApiException(ApiException.ApiExceptionEnum.SNIPPET_NOT_FOUND);
        }
        return SnippetConverter.convertToMinSnippetDTO(snippet);
    }
}
