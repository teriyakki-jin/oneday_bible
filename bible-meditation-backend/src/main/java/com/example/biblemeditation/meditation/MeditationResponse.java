package com.example.biblemeditation.meditation;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MeditationResponse {
    private String reference;
    private String verseText;

    private String summary;
    private List<String> easyInterpretation;
    private List<String> keyPoints;
    private List<String> questions;

    private String practice;
    private String prayer;
    private String caution;
}
