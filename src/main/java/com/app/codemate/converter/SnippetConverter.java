package com.app.codemate.converter;

import com.app.codemate.request.JDoodleExecuteRequest;
import com.app.codemate.request.SnippetExecuteRequest;
import com.app.codemate.response.JDoodleExecuteResponse;
import com.app.codemate.response.SnippetExecuteResponse;

public class SnippetConverter {
    public static JDoodleExecuteRequest convertToJDoodleExecuteRequest(SnippetExecuteRequest request) {
        JDoodleExecuteRequest doodleExecuteRequest = new JDoodleExecuteRequest();
        doodleExecuteRequest.setScript(request.getScript());
        doodleExecuteRequest.setLanguage(request.getLanguage().getValue());
        doodleExecuteRequest.setVersionIndex(request.getVersion().getIndex());
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
}
