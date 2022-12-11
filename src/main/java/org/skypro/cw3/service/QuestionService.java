package org.skypro.cw3.service;

import org.skypro.cw3.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();

}
