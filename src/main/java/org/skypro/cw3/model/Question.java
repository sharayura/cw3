package org.skypro.cw3.model;

import org.apache.commons.lang3.StringUtils;
import org.skypro.cw3.service.BadRequestException;
import org.springframework.http.HttpStatus;

import java.util.Objects;

public class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        if (StringUtils.isBlank(question) || StringUtils.isBlank(answer)) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Запрос неполный");
        }
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
