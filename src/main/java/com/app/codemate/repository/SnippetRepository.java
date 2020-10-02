package com.app.codemate.repository;

import com.app.codemate.model.SnippetModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnippetRepository extends MongoRepository<SnippetModel, Long> {
    SnippetModel findByUid(String uid);
}
