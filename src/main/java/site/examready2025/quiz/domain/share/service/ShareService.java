package site.examready2025.quiz.domain.share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.examready2025.quiz.domain.quiz.entity.Quiz;
import site.examready2025.quiz.domain.quiz.repository.QuizRepository;
import site.examready2025.quiz.domain.share.dto.ShareRequestDto;
import site.examready2025.quiz.domain.share.dto.ShareResponseDto;

@Service
@RequiredArgsConstructor
public class ShareService {

    private final QuizRepository quizRepository;

    // 퀴즈 공유 URL 생성
    public ShareResponseDto generateShareUrl(ShareRequestDto requestDto) {
        // 퀴즈 확인
//        Quiz quiz = quizRepository.findById(requestDto.getQuizId())
//                .orElseThrow(() -> new IllegalArgumentException("퀴즈를 찾을 수 없습니다. 퀴즈 ID: " + requestDto.getQuizId()));

        Quiz quiz = quizRepository.findByShareKey(requestDto.getShareKey())
                .orElseThrow(()-> new IllegalArgumentException("해당 퀴즈를 찾을 수 없습니다."));

        // 공유 URL 생성
        String shareUrl = "https://examready2025.site/quiz/" + quiz.getShareKey();

        return ShareResponseDto.builder()
                .shareUrl(shareUrl)
                .build();
    }
}