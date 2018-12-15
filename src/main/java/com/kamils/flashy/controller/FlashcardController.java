package com.kamils.flashy.controller;

import com.kamils.flashy.dal.flashcard.FlashcardDAL;
import com.kamils.flashy.dal.repositories.FlashcardRepository;
import com.kamils.flashy.model.Flashcard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/flashcard")
public class FlashcardController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final FlashcardRepository flashcardRepository;
    private final FlashcardDAL flashcardDAL;

    public FlashcardController(FlashcardRepository flashcardRepository, FlashcardDAL flashcardDAL) {
        this.flashcardRepository = flashcardRepository;
        this.flashcardDAL = flashcardDAL;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Flashcard addNewFlashcards(@RequestBody Flashcard flashcard) {
        LOG.info("Saving flashcard.");
        return flashcardDAL.addNewFlashcard(flashcard);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Flashcard> getAllFlashcards() {
        LOG.info("Getting all flashcards.");
        return flashcardRepository.findAll();
    }

    @RequestMapping(value = "/{flashcardId}", method = RequestMethod.GET)
    public Flashcard getFlashcard(@PathVariable String flashcardId) {
        LOG.info("Getting flashcard with ID: {}.", flashcardId);
        return flashcardRepository.findOne(flashcardId);
    }

    @RequestMapping(value = "/delete/{flashcardId}", method = RequestMethod.DELETE)
    public void deleteFlashcard(@PathVariable String flashcardId) {
        LOG.info("Deleting flashcard with ID: {}.", flashcardId);
        flashcardRepository.delete(flashcardId);
    }

    @RequestMapping(value = "/update/{flashcardId}/{title}/{content}", method = RequestMethod.PUT)
    public void updateFlashcard(@PathVariable String flashcardId,
                                @PathVariable String title,
                                @PathVariable String content) {

        LOG.info("Deleting flashcard with ID: {}.", flashcardId);
        flashcardDAL.updateFlashcard(flashcardId, title, content);
    }
}
