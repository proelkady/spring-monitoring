package com.proelkady.monitoring.servicea.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("requests")
public class Request {
    private ObjectId id;
    private String uuid;
    private Date createdAt;
}
