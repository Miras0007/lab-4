package com.example.lab3_java_ee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

////Mongo
@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}

