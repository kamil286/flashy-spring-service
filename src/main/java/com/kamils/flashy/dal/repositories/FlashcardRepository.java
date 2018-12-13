package com.kamils.flashy.dal.repositories;

import com.kamils.flashy.model.Flashcard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepository extends MongoRepository<Flashcard, String> { }
