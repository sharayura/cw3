package org.skypro.cw3.service;

import org.skypro.cw3.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions;
    private final  Random rand = new Random();

    public JavaQuestionService() {
        questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        var questionNew = new Question(question, answer);
        questions.add(questionNew);
        return questionNew;
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

    @Override
    public Question getRandomQuestion() {
        int randomNumber = rand.nextInt(questions.size());
        Iterator<Question> it = questions.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (i == randomNumber) {
                return it.next();
            }
            it.next();
            i++;
        }
        return null;
    }
}
