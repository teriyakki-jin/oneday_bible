package com.example.biblemeditation.meditation;

import java.time.Instant;

public class MeditationResponse {
    private final String reference;
    private final String verseText;
    private final String reflection;
    private final String prayer;
    private final String contextTag;
    private final Instant createdAt;

    public MeditationResponse(
            String reference,
            String verseText,
            String reflection,
            String prayer,
            String contextTag,
            Instant createdAt
    ) {
        this.reference = reference;
        this.verseText = verseText;
        this.reflection = reflection;
        this.prayer = prayer;
        this.contextTag = contextTag;
        this.createdAt = createdAt;
    }

    public String getReference() {
        return reference;
    }

    public String getVerseText() {
        return verseText;
    }

    public String getReflection() {
        return reflection;
    }

    public String getPrayer() {
        return prayer;
    }

    public String getContextTag() {
        return contextTag;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
