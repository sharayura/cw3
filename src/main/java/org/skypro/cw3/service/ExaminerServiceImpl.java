package org.skypro.cw3.service;

import org.skypro.cw3.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "У нас всего вопросов: "
                    + questionService.getAll().size());
        }
        Collection<Question> randomQuestions = new HashSet<>(amount);
        while (randomQuestions.size() < amount) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
