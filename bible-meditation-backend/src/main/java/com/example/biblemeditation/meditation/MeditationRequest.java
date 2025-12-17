package com.example.biblemeditation.meditation;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeditationRequest {

    /**
     * 예: "John 3:16", "요 3:16"
     */
    @NotBlank(message = "reference is required")
    private String reference;

    /**
     * 선택: 프론트가 본문을 보내거나, 추후 백엔드에서 가져오도록 확장 가능
     */
    private String verseText;

    /**
     * 선택: 상황/감정 태그 (anxiety, gratitude, relationship, etc.)
     */
    private String contextTag;
}
