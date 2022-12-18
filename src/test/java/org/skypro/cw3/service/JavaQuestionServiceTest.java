package org.skypro.cw3.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skypro.cw3.model.Question;

public class JavaQuestionServiceTest {
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private Question question5;

    private QuestionService questionService;

    @BeforeEach
    public void setup() {
        question1 = new Question("Question1", "Answer1");
        question2 = new Question("Question2", "Answer2");
        question3 = new Question("Question3", "Answer3");
        question4 = new Question("Question4", "Answer4");
        question5 = new Question("Question5", "Answer5");

        questionService = new JavaQuestionService();
        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question3);
        questionService.add(question4);

    }

    @Test
    public void shouldAddQuestionTest() {
        questionService.add(question5);
        Assertions.assertTrue(questionService.getAll().contains(question5));
    }

    @Test
    public void shouldTrowBadRequestExceptionWhenAddedNullTest() {
        Assertions.assertThrows(BadRequestException.class, () -> questionService.add("Question", null));
    }

    @Test
    public void shouldRemoveQuestionTest() {
        questionService.remove(question1);
        Assertions.assertFalse(questionService.getAll().contains(question1));
    }

    @Test
    public void shouldGetRandomQuestionTest() {
        Question randomQuestion = questionService.getRandomQuestion();
        Assertions.assertTrue(questionService.getAll().contains(randomQuestion));
    }
}
