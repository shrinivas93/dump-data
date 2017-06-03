package com.shri.dumpdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shri.dumpdata.document.Data;

public interface DataRepository extends MongoRepository<Data, String> {

}
