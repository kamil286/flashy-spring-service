package com.kamils.flashy.dal.repositories;

import com.kamils.flashy.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> { }
