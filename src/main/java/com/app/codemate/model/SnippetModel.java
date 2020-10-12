package com.app.codemate.model;

import com.app.codemate.enums.LanguageEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "snippets")
public class SnippetModel extends AbstractModel {

    @Indexed(unique = true)
    private String uid;

    private String snippet;

    private LanguageEnum language;
}
