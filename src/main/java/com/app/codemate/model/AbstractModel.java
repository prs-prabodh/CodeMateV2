package com.app.codemate.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
public class AbstractModel {

    @Id
    private ObjectId id;

    @CreatedDate
    private Date created;

    @LastModifiedDate
    private Date updated;
}
