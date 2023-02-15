package com.libraray.repository;

import com.libraray.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface StudentRepo extends MongoRepository<Student , UUID> {
}
