package com.app.codemate.service.helper;

import com.app.codemate.model.SnippetModel;
import com.app.codemate.repository.SnippetRepository;
import com.app.codemate.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SnippetHelperService {

    @Autowired
    private SnippetRepository snippetRepository;

    public String generateValidUid() {
        String uid;
        while(true) {
            uid = KeyUtil.generateUid();
            SnippetModel snippet = snippetRepository.findByUid(uid);
            if (snippet == null) {
                break;
            }
        }
        return uid;
    }
}
