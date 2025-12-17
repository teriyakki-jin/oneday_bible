package com.example.biblemeditation.meditation;

import java.util.*;

/**
 * 샘플 묵상 데이터 모음 (MVP용)
 * - reference key는 normalize된 형태(예: "john 3:16")로 저장
 */
public class SampleMeditations {

    public static Map<String, MeditationResponse> build() {
        Map<String, MeditationResponse> map = new HashMap<>();

        map.put("john 3:16", MeditationResponse.builder()
                .reference("John 3:16")
                .verseText(null)
                .summary("하나님 사랑은 먼저 왔고, 믿음은 그 사랑을 받아들이는 길이다.")
                .easyInterpretation(List.of(
                        "이 구절은 하나님이 먼저 사랑하셨다는 사실을 보여줘요.",
                        "그 사랑은 말이 아니라 행동으로 드러났고, 우리는 믿음으로 응답할 수 있어요.",
                        "오늘은 '내가 증명해야 사랑받는가'를 내려놓고, '이미 사랑받는가'를 붙잡아 보세요."
                ))
                .keyPoints(List.of("사랑의 주도권", "믿음의 응답", "현재의 위로"))
                .questions(List.of(
                        "오늘 내가 붙잡고 있는 두려움은 무엇이야?",
                        "‘사랑받는 존재’라는 사실이 내 선택을 어떻게 바꿀까?",
                        "지금 내가 믿음으로 한 걸음 옮길 수 있는 작은 행동은?"
                ))
                .practice("오늘 10분, ‘나는 사랑받고 있다’는 전제로 하루 계획을 다시 적어보기")
                .prayer("하나님, 오늘도 사랑 안에 머물게 해주세요. 두려움보다 주님의 사랑을 믿게 해주세요.")
                .caution("이 구절을 ‘성과’의 조건으로 읽기보다 ‘초대’로 읽어보세요.")
                .build());

        map.put("psalm 23:1", MeditationResponse.builder()
                .reference("Psalm 23:1")
                .summary("부족함을 느끼는 순간에도, 인도하시는 분이 계시다.")
                .easyInterpretation(List.of(
                        "‘목자’는 방향을 알려주고, 위험에서 지켜주고, 필요한 것을 공급해요.",
                        "내가 불안할수록 더 크게 붙잡는 건 ‘통제’인데, 이 구절은 ‘인도’로 초대해요."
                ))
                .keyPoints(List.of("인도", "공급", "불안에서 신뢰로"))
                .questions(List.of(
                        "요즘 내가 ‘부족하다’고 느끼는 건 정확히 뭐야?",
                        "내가 통제하려는 영역은 어디야?",
                        "오늘 한 가지를 내려놓고 맡길 수 있을까?"
                ))
                .practice("오늘 불안한 항목 1개를 적고, ‘맡긴다’는 결단문을 한 줄로 써보기")
                .prayer("하나님, 제가 붙잡은 통제를 내려놓고 주님의 인도를 신뢰하게 해주세요.")
                .caution("‘부족함=실패’로 연결하지 말고, ‘인도하심’의 관점으로 다시 보세요.")
                .build());

        map.put("philippians 4:6", MeditationResponse.builder()
                .reference("Philippians 4:6")
                .summary("걱정이 올라올 때, 기도는 현실도피가 아니라 방향 전환이다.")
                .easyInterpretation(List.of(
                        "걱정이 없어야 기도하는 게 아니라, 걱정이 생길 때 기도로 전환하는 거예요.",
                        "감사는 ‘아직’ 해결되지 않아도 붙잡는 신뢰의 표현일 수 있어요."
                ))
                .keyPoints(List.of("전환", "감사", "마음의 훈련"))
                .questions(List.of(
                        "내가 반복해서 걱정하는 주제는 뭐야?",
                        "그 걱정 속에서 내가 원하는 건 ‘통제’일까 ‘평안’일까?",
                        "감사로 바꿀 수 있는 작은 사실은?"
                ))
                .practice("걱정 1개를 ‘기도문 한 문장’으로 바꿔서 메모해두기")
                .prayer("하나님, 걱정이 기도로 바뀌게 하시고 제 마음을 지켜주세요.")
                .caution("감정 억압이 아니라 ‘방향 전환’으로 이해해보세요.")
                .build());

        map.put("matthew 5:3", MeditationResponse.builder()
                .reference("Matthew 5:3")
                .summary("내가 비어있다고 느낄 때, 하나님 나라의 시작점이 될 수 있다.")
                .easyInterpretation(List.of(
                        "‘심령이 가난한’ 것은 자책이 아니라, 도움을 구할 수 있는 마음의 상태예요.",
                        "강해 보이려 애쓸수록 지치는데, 이 구절은 ‘의존’의 복을 말해요."
                ))
                .keyPoints(List.of("의존", "겸손", "시작"))
                .questions(List.of(
                        "내가 요즘 강한 척하려는 부분은 어디야?",
                        "도움을 요청할 수 있는 사람/방법이 있을까?",
                        "내 빈자리를 하나님께 내어드릴 수 있을까?"
                ))
                .practice("오늘 도움 요청 1번 해보기(작게: 질문 하나 보내기)")
                .prayer("하나님, 제 부족함을 숨기지 않게 하시고 주님께 기대게 해주세요.")
                .caution("‘가난함’을 자기혐오로 바꾸지 말고, ‘의존의 용기’로 읽어보세요.")
                .build());

        map.put("romans 8:28", MeditationResponse.builder()
                .reference("Romans 8:28")
                .summary("내가 이해 못하는 조각들도, 선을 향한 흐름 안에 놓일 수 있다.")
                .easyInterpretation(List.of(
                        "이 구절은 모든 일이 ‘좋다’고 말하기보다, 하나님이 ‘선을 이루신다’에 초점이 있어요.",
                        "지금은 의미가 안 보일 수 있지만, 포기 대신 신뢰를 선택하게 도와줘요."
                ))
                .keyPoints(List.of("해석 유보", "신뢰", "선한 방향"))
                .questions(List.of(
                        "요즘 내 마음에서 ‘왜’가 가장 큰 부분은?",
                        "내가 지금 당장 의미를 확정하려는 건 없을까?",
                        "오늘 내가 할 수 있는 ‘선한 선택’ 한 가지는?"
                ))
                .practice("오늘 ‘내가 통제할 수 있는 것/없는 것’ 리스트를 나누어 적기")
                .prayer("하나님, 지금 이해되지 않아도 선을 이루실 주님을 신뢰하게 해주세요.")
                .caution("이 구절로 고통을 단순화하지 말고, ‘동행’의 약속으로 받아보세요.")
                .build());

        return map;
    }
}
