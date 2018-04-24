package com.cisco.dao;

import com.cisco.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by liu on 2017/6/7.
 */
public interface BookDao extends MongoRepository<Book, ObjectId> {

}
