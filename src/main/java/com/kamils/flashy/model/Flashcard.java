package com.kamils.flashy.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Flashcard {
    @Id
    private String flashcardId;
    private String title;
    private String content;
    private Date creationDate = new Date();

    public String getFlashcardId() {
        return flashcardId;
    }

    public void setFlashcardId(String flashcardId) {
        this.flashcardId = flashcardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.title = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

