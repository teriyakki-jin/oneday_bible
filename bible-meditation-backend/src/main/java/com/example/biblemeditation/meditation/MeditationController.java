package com.example.biblemeditation.meditation;

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meditations")
public class MeditationController {

    private final MeditationService meditationService;

    public MeditationController(MeditationService meditationService) {
        this.meditationService = meditationService;
    }

    @PostMapping
    public ResponseEntity<MeditationResponse> createMeditation(@Valid @RequestBody MeditationRequest request) {
        return ResponseEntity.ok(meditationService.createMeditation(request));
    }

    @GetMapping("/recent")
    public ResponseEntity<List<MeditationResponse>> recentMeditations() {
        return ResponseEntity.ok(meditationService.recentMeditations());
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        return ResponseEntity.ok(Map.of("status", "ok"));
    }
}
