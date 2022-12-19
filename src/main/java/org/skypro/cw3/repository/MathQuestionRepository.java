package org.skypro.cw3.repository;

import jakarta.annotation.PostConstruct;
import org.skypro.cw3.model.Question;
import org.skypro.cw3.service.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository{
    private final Set<Question> questions;

    public MathQuestionRepository() {
        questions = new HashSet<>();
    }

    @PostConstruct
    private void init() {
        questions.add(new Question("math Question1", "math Answer1"));
        questions.add(new Question("math Question2", "math Answer2"));
        questions.add(new Question("math Question3", "math Answer3"));
        questions.add(new Question("math Question4", "math Answer4"));
        questions.add(new Question("math Question5", "math Answer5"));
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Запрос неполный");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (question == null || !questions.contains(question)) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Такого вопроса нет");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
