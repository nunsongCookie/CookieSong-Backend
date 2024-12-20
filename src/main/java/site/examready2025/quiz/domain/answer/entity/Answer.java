package site.examready2025.quiz.domain.answer.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.examready2025.quiz.domain.option.entity.Option;
import site.examready2025.quiz.domain.question.entity.Question;
import site.examready2025.quiz.domain.response.entity.Response;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "response_id", nullable = false)
    private Response response;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "selected_option_id", nullable = false)
    private Option selectedOption;

    @Builder
    public Answer(Response response, Question question, Option selectedOption) {
        this.response = response;
        this.question = question;
        this.selectedOption = selectedOption;
    }
}