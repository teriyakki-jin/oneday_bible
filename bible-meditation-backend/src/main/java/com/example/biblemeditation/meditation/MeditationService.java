package com.example.biblemeditation.meditation;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MeditationService {
    private static final Map<String, String> SUGGESTED_VERSES = Map.of(
            "anxiety", "Do not be anxious about anything, but in every situation, by prayer and petition, with thanksgiving, present your requests to God. (Philippians 4:6)",
            "hope", "Those who hope in the Lord will renew their strength. They will soar on wings like eagles. (Isaiah 40:31)",
            "gratitude", "Give thanks to the Lord, for he is good; his love endures forever. (Psalm 107:1)",
            "rest", "Come to me, all you who are weary and burdened, and I will give you rest. (Matthew 11:28)",
            "guidance", "Trust in the Lord with all your heart and lean not on your own understanding. (Proverbs 3:5)"
    );

    private final List<MeditationResponse> history = new CopyOnWriteArrayList<>();

    public MeditationResponse createMeditation(MeditationRequest request) {
        String normalizedTag = normalizeTag(request.getContextTag());
        String verseText = resolveVerseText(request.getVerseText(), normalizedTag);

        String reflection = buildReflection(request.getReference(), verseText, normalizedTag);
        String prayer = buildPrayer(normalizedTag);

        MeditationResponse response = new MeditationResponse(
                request.getReference(),
                verseText,
                reflection,
                prayer,
                normalizedTag,
                Instant.now()
        );

        addToHistory(response);
        return response;
    }

    public List<MeditationResponse> recentMeditations() {
        List<MeditationResponse> snapshot = new ArrayList<>(history);
        Collections.reverse(snapshot);
        return snapshot;
    }

    private void addToHistory(MeditationResponse response) {
        history.add(response);
        if (history.size() > 20) {
            history.remove(0);
        }
    }

    private String resolveVerseText(String verseText, String normalizedTag) {
        if (StringUtils.hasText(verseText)) {
            return verseText.trim();
        }

        return SUGGESTED_VERSES.getOrDefault(
                normalizedTag,
                "Slow down for a moment. Invite the Spirit to speak through this passage and listen for God's gentle guidance."
        );
    }

    private String buildReflection(String reference, String verseText, String normalizedTag) {
        Map<String, String> prompts = new LinkedHashMap<>();
        prompts.put("anxiety", "Imagine placing your worries into God's hands as you read this passage. What eases in your heart?");
        prompts.put("hope", "Look for a promise in this verse. How does it reshape what you are facing today?");
        prompts.put("gratitude", "Notice a reason to give thanks in these words. What small gift can you acknowledge right now?");
        prompts.put("rest", "Read slowly and breathe. Where do you sense Jesus inviting you to rest?");
        prompts.put("guidance", "As you meditate, ask the Spirit to highlight one word or phrase. What next step comes to mind?");

        String basePrompt = prompts.getOrDefault(
                normalizedTag,
                "Sit quietly with this verse. What does God's character look like here, and how might you respond?"
        );

        return """
                Reference: %s\n
                %s\n
                %s""".formatted(reference, verseText, basePrompt);
    }

    private String buildPrayer(String normalizedTag) {
        Map<String, String> prayers = new LinkedHashMap<>();
        prayers.put("anxiety", "주님, 제 걱정을 주님께 맡깁니다. 당신의 평안으로 제 마음을 채워주세요.");
        prayers.put("hope", "하나님, 소망을 주셔서 감사합니다. 오늘도 주님의 약속을 믿고 걷게 해주세요.");
        prayers.put("gratitude", "아버지, 오늘 주신 은혜에 감사드립니다. 감사의 마음을 잃지 않게 해주세요.");
        prayers.put("rest", "예수님, 지친 제 마음을 쉬게 해주세요. 주님 안에서 깊은 안식을 누리게 해주세요.");
        prayers.put("guidance", "성령님, 제 걸음을 인도해주세요. 주님의 지혜로 다음 걸음을 분별하게 해주세요.");

        return prayers.getOrDefault(
                normalizedTag,
                "주님, 이 말씀을 통해 제 마음을 비추어 주세요. 당신의 사랑에 응답하며 살아가게 해주세요."
        );
    }

    private String normalizeTag(String contextTag) {
        if (!StringUtils.hasText(contextTag)) {
            return "general";
        }
        return contextTag.trim().toLowerCase(Locale.ROOT);
    }
}
