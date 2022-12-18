package org.skypro.cw3.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.cw3.model.Question;

import java.util.Collection;
import java.util.HashSet;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService questionServiceMock; // = mock(JavaQuestionService.class);

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private Question question5;
    private Collection<Question> questionsMock;


    @BeforeEach
    public void setup() {
        examinerService = new ExaminerServiceImpl(questionServiceMock);
        question1 = new Question("Question1", "Answer1");
        question2 = new Question("Question2", "Answer2");
        question3 = new Question("Question3", "Answer3");
        question4 = new Question("Question4", "Answer4");
        question5 = new Question("Question5", "Answer5");
        questionsMock = new HashSet<>();
        questionsMock.add(question1);
        questionsMock.add(question2);
        questionsMock.add(question3);
        questionsMock.add(question4);
        questionsMock.add(question5);
        Mockito.when(questionServiceMock.getAll()).thenReturn(questionsMock);

    }

    @Test
    public void shouldThrowBadRequestExceptionWhenAmountBigTest() {
        Assertions.assertThrows(BadRequestException.class, () -> examinerService.getQuestions(questionsMock.size() + 1));
    }

    @Test
    public void shouldReturnSameHashSetTest() {
        Mockito.when(questionServiceMock.getRandomQuestion()).thenReturn(question1).thenReturn(question3)
                .thenReturn(question2).thenReturn(question5).thenReturn(question4);
        Assertions.assertEquals(questionsMock, examinerService.getQuestions(questionsMock.size()));
    }

}
