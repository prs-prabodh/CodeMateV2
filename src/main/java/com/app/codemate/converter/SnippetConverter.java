package com.app.codemate.converter;

import com.app.codemate.dto.MinSnippetDTO;
import com.app.codemate.model.SnippetModel;
import com.app.codemate.request.JDoodleExecuteRequest;
import com.app.codemate.request.SnippetExecuteRequest;
import com.app.codemate.request.SnippetSaveRequest;
import com.app.codemate.response.JDoodleExecuteResponse;
import com.app.codemate.response.SnippetExecuteResponse;
import com.app.codemate.response.SnippetSaveResponse;
import com.app.codemate.util.KeyUtil;

public class SnippetConverter {
    public static JDoodleExecuteRequest convertToJDoodleExecuteRequest(SnippetExecuteRequest request) {
        JDoodleExecuteRequest doodleExecuteRequest = new JDoodleExecuteRequest();
        doodleExecuteRequest.setScript(request.getScript());
        doodleExecuteRequest.setLanguage(request.getLanguage().getValue());
        return doodleExecuteRequest;
    }

    public static SnippetExecuteResponse convertToSnippetExecuteResponse(JDoodleExecuteResponse response) {
        SnippetExecuteResponse snippetExecuteResponse = new SnippetExecuteResponse();
        snippetExecuteResponse.setError(response.getError());
        snippetExecuteResponse.setOutput(response.getOutput());
        snippetExecuteResponse.setMemory(response.getMemory());
        snippetExecuteResponse.setCpuTime(response.getCpuTime());
        return snippetExecuteResponse;
    }

    public static SnippetModel convertToSnippetModel(SnippetSaveRequest request, String uid) {
        SnippetModel snippet = new SnippetModel();
        snippet.setSnippet(request.getSnippet());
        snippet.setLanguage(request.getLanguage());
        snippet.setVersion(request.getVersion());
        snippet.setUid(uid);
        return snippet;
    }

    public static SnippetSaveResponse convertToSnippetSaveResponse(SnippetModel snippet) {
        SnippetSaveResponse response = new SnippetSaveResponse();
        response.setUid(snippet.getUid());
        return response;
    }

    public static MinSnippetDTO convertToMinSnippetDTO(SnippetModel snippet) {
        MinSnippetDTO minSnippetDTO = new MinSnippetDTO();
        minSnippetDTO.setSnippet(snippet.getSnippet());
        minSnippetDTO.setLanguage(snippet.getLanguage());
        minSnippetDTO.setVersion(snippet.getVersion());
        return minSnippetDTO;
    }
}
