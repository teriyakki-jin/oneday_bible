package com.example.biblemeditation.meditation;

import java.time.Instant;
import java.util.List;

public class MeditationResponse {
    private final String reference;
    private final String verseText;
    private final String reflection;
    private final String prayer;
    private final String contextTag;
    private final Instant createdAt;

    private final String summary;
    private final List<String> easyInterpretation;
    private final List<String> keyPoints;
    private final List<String> questions;
    private final String practice;
    private final String caution;

    public MeditationResponse(
            String reference,
            String verseText,
            String reflection,
            String prayer,
            String contextTag,
            Instant createdAt
    ) {
        this(reference, verseText, reflection, prayer, contextTag, createdAt, null, null, null, null, null, null);
    }

    private MeditationResponse(
            String reference,
            String verseText,
            String reflection,
            String prayer,
            String contextTag,
            Instant createdAt,
            String summary,
            List<String> easyInterpretation,
            List<String> keyPoints,
            List<String> questions,
            String practice,
            String caution
    ) {
        this.reference = reference;
        this.verseText = verseText;
        this.reflection = reflection;
        this.prayer = prayer;
        this.contextTag = contextTag;
        this.createdAt = createdAt;
        this.summary = summary;
        this.easyInterpretation = easyInterpretation;
        this.keyPoints = keyPoints;
        this.questions = questions;
        this.practice = practice;
        this.caution = caution;
    }

    public static Builder builder() {
        return new Builder();
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

    public String getSummary() {
        return summary;
    }

    public List<String> getEasyInterpretation() {
        return easyInterpretation;
    }

    public List<String> getKeyPoints() {
        return keyPoints;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public String getPractice() {
        return practice;
    }

    public String getCaution() {
        return caution;
    }

    public static class Builder {
        private String reference;
        private String verseText;
        private String reflection;
        private String prayer;
        private String contextTag;
        private Instant createdAt;
        private String summary;
        private List<String> easyInterpretation;
        private List<String> keyPoints;
        private List<String> questions;
        private String practice;
        private String caution;

        public Builder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public Builder verseText(String verseText) {
            this.verseText = verseText;
            return this;
        }

        public Builder reflection(String reflection) {
            this.reflection = reflection;
            return this;
        }

        public Builder prayer(String prayer) {
            this.prayer = prayer;
            return this;
        }

        public Builder contextTag(String contextTag) {
            this.contextTag = contextTag;
            return this;
        }

        public Builder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder easyInterpretation(List<String> easyInterpretation) {
            this.easyInterpretation = easyInterpretation;
            return this;
        }

        public Builder keyPoints(List<String> keyPoints) {
            this.keyPoints = keyPoints;
            return this;
        }

        public Builder questions(List<String> questions) {
            this.questions = questions;
            return this;
        }

        public Builder practice(String practice) {
            this.practice = practice;
            return this;
        }

        public Builder caution(String caution) {
            this.caution = caution;
            return this;
        }

        public MeditationResponse build() {
            Instant finalCreatedAt = createdAt != null ? createdAt : Instant.now();
            return new MeditationResponse(
                    reference,
                    verseText,
                    reflection,
                    prayer,
                    contextTag,
                    finalCreatedAt,
                    summary,
                    copyOrNull(easyInterpretation),
                    copyOrNull(keyPoints),
                    copyOrNull(questions),
                    practice,
                    caution
            );
        }

        private List<String> copyOrNull(List<String> input) {
            return input == null ? null : List.copyOf(input);
        }
    }
}
