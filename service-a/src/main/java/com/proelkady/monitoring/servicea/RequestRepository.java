package com.proelkady.monitoring.servicea;

import com.proelkady.monitoring.servicea.model.Request;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository  extends MongoRepository<Request, ObjectId> {
}
