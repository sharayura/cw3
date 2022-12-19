package org.skypro.cw3.service;

import org.skypro.cw3.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServiceList;

    public ExaminerServiceImpl(List<QuestionService> questionServiceList) {
        this.questionServiceList = questionServiceList;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        int actualAmount = 0;
        for (QuestionService questionService : questionServiceList) {
            actualAmount += questionService.getAll().size();
        }
        if (amount > actualAmount) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "У нас всего вопросов: "
                    + actualAmount);
        }
        Collection<Question> randomQuestions = new HashSet<>(amount);
        Random rand = new Random();
        while (randomQuestions.size() < amount) {
            randomQuestions.add(questionServiceList.get(rand.nextInt(questionServiceList.size())).getRandomQuestion());
        }
        return randomQuestions;
    }
}
