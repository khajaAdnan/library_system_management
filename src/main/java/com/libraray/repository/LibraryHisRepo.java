package com.libraray.repository;

import com.libraray.model.LibraryHis;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface LibraryHisRepo extends MongoRepository<LibraryHis , UUID> {
}
