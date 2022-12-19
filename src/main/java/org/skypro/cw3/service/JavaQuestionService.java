package org.skypro.cw3.service;

import org.skypro.cw3.model.Question;
import org.skypro.cw3.repository.JavaQuestionRepository;
import org.skypro.cw3.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final QuestionRepository questionRepository;
    private final  Random rand = new Random();

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        var questionNew = new Question(question, answer);
        questionRepository.add(questionNew);
        return questionNew;
    }

    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        int randomNumber = rand.nextInt(questionRepository.getAll().size());
        int i = 0;
        for (Question question : questionRepository.getAll()) {
            if (i++ == randomNumber) {
                return question;
            }
        }
        return null;
    }
}
