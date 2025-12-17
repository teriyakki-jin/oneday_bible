package com.example.biblemeditation.meditation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/meditations")
public class MeditationController {

    private final MeditationService meditationService;

    @PostMapping
    public ResponseEntity<MeditationResponse> create(@Valid @RequestBody MeditationRequest request) {
        return ResponseEntity.ok(meditationService.create(request));
    }

    /**
     * 간단 헬스체크
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
