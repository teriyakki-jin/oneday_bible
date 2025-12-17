package com.example.biblemeditation.meditation;

import jakarta.validation.constraints.NotBlank;

public class MeditationRequest {
    @NotBlank(message = "성경 구절 참조를 입력해주세요.")
    private String reference;
    private String verseText;
    private String contextTag;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getVerseText() {
        return verseText;
    }

    public void setVerseText(String verseText) {
        this.verseText = verseText;
    }

    public String getContextTag() {
        return contextTag;
    }

    public void setContextTag(String contextTag) {
        this.contextTag = contextTag;
    }
}
