package com.app.codemate.manager;

import com.app.codemate.model.SnippetModel;
import com.app.codemate.repository.SnippetRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SnippetManager {

    @Autowired
    private SnippetRepository snippetRepository;

    public SnippetModel findSnippetByUid(String uid) {
        if (StringUtils.isNotEmpty(uid)) {
            return snippetRepository.findByUid(uid);
        }
        return null;
    }
}
