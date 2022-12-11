package org.skypro.cw3.service;

import org.skypro.cw3.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
