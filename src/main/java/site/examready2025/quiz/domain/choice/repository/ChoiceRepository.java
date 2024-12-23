package site.examready2025.quiz.domain.choice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.examready2025.quiz.domain.choice.entity.Choice;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {

    //@Query("SELECT c FROM Choice c WHERE c.quiz.id = :quizId AND c.question.id = :questionId AND c.id = :choiceId")
    Optional<Choice> findByQuizIdAndQuestionIdAndId(Long quizId, Long questionId, Long choiceId);

    List<Choice> findByQuizId(Long quizId);
}
