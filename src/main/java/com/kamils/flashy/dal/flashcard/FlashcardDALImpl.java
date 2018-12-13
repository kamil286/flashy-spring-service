package com.kamils.flashy.dal.flashcard;

import com.kamils.flashy.model.Flashcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlashcardDALImpl implements FlashcardDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Flashcard> getAllFlashcards() {
        return mongoTemplate.findAll(Flashcard.class);
    }

    @Override
    public Flashcard getFlashcardById(String flashcardId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("flashcardId").is(flashcardId));
        return mongoTemplate.findOne(query, Flashcard.class);
    }

    @Override
    public Flashcard addNewFlashcard(Flashcard flashcard) {
        mongoTemplate.save(flashcard);
        return flashcard;
    }

    @Override
    public void deleteFlashcard(String flashcardId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("flashcardId").is(flashcardId));
        mongoTemplate.findAndRemove(query, Flashcard.class);
    }

    @Override
    public void updateFlashcard(String flashcardId, String title, String content) {
        Query query = new Query();
        query.addCriteria(Criteria.where("flashcardId").is(flashcardId));
        Update update = new Update();
        update.set("title", title);
        update.set("content", content);
        mongoTemplate.updateFirst(query, update, Flashcard.class);
    }
}
