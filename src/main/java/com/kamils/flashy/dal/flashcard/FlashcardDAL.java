package com.kamils.flashy.dal.flashcard;

import com.kamils.flashy.model.Flashcard;

import java.util.List;

public interface FlashcardDAL {
    List<Flashcard> getAllFlashcards();

    Flashcard getFlashcardById(String flashcardId);

    Flashcard addNewFlashcard(Flashcard flashcard);

    void deleteFlashcard(String flashcardId);

    void updateFlashcard(String flashcardId, String title, String content);
}
