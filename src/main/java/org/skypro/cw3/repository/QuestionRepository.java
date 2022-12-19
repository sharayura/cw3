package org.skypro.cw3.repository;

import org.skypro.cw3.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();

}
