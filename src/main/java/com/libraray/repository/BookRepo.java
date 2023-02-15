package com.libraray.repository;

import com.libraray.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepo extends MongoRepository<Book, UUID> {

}
