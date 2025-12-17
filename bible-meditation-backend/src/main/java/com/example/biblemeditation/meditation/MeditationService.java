package com.example.biblemeditation.meditation;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MeditationService {

    /**
     * MVP: reference별 샘플 데이터 제공 (AI/DB 없이도 바로 동작)
     * - 나중에 여기만 교체해서 AI 생성/DB 저장으로 확장하면 됨
     */
    private final Map<String, MeditationResponse> samples;

    public MeditationService() {
        this.samples = SampleMeditations.build();
    }

    public MeditationResponse create(MeditationRequest request) {
        String key = normalize(request.getReference());

        // 샘플 우선 제공
        MeditationResponse sample = samples.get(key);
        if (sample != null) {
            // verseText가 요청에 들어오면 덮어쓰기(옵션)
            if (request.getVerseText() != null && !request.getVerseText().isBlank()) {
                return MeditationResponse.builder()
                        .reference(sample.getReference())
                        .verseText(request.getVerseText())
                        .summary(sample.getSummary())
                        .easyInterpretation(sample.getEasyInterpretation())
                        .keyPoints(sample.getKeyPoints())
                        .questions(sample.getQuestions())
                        .practice(sample.getPractice())
                        .prayer(sample.getPrayer())
                        .caution(sample.getCaution())
                        .build();
            }
            return sample;
        }

        // 샘플이 없으면 "기본 템플릿"으로 반환 (사용감 유지)
        return MeditationResponse.builder()
                .reference(request.getReference())
                .verseText(request.getVerseText())
                .summary("이 구절을 '정보'가 아니라 '초대'로 읽어보세요.")
                .easyInterpretation(List.of(
                        "먼저, 문맥을 떠올려 보세요(누가 누구에게 말하는지).",
                        "그 다음, 지금 내 삶에 연결되는 단어 하나를 고르세요.",
                        "마지막으로, 오늘 실천할 수 있는 작은 행동을 정해보세요."
                ))
                .keyPoints(List.of("문맥", "핵심 단어", "작은 실천"))
                .questions(List.of(
                        "이 구절에서 오늘 나에게 가장 걸리는 단어는 무엇이야?",
                        "내가 지금 놓치고 있는 관점은 없을까?",
                        "오늘 5분 안에 할 수 있는 순종/실천은?"
                ))
                .practice("오늘 5분, 이 구절을 한 번 천천히 소리 내어 읽고 한 문장으로 요약해 보기")
                .prayer("하나님, 오늘 제 마음이 말씀 앞에서 부드러워지게 해주세요.")
                .caution("단정하기보다, 성찰과 적용으로 이어가 보세요.")
                .build();
    }

    /**
     * 아주 단순한 표준화:
     * - 공백 제거, 대소문자 통일, 일부 약어 처리
     */
    private String normalize(String reference) {
        if (reference == null) return "";
        String r = reference.trim()
                .replaceAll("\s+", " ")
                .toLowerCase(Locale.ROOT);

        // 한글 약어를 영어 키로 단순 매핑 (필요하면 추가)
        r = r.replace("요 ", "john ");
        r = r.replace("시 ", "psalm ");
        r = r.replace("빌 ", "philippians ");
        r = r.replace("마 ", "matthew ");
        r = r.replace("롬 ", "romans ");

        return r;
    }
}
