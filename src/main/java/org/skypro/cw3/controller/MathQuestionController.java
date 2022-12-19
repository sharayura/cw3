package org.skypro.cw3.controller;

import org.skypro.cw3.model.Question;
import org.skypro.cw3.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService service;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService service) {
        this.service = service;
    }

    @RequestMapping("/add")
    public Question addQuestion(@RequestParam String question, String answer) {
        return service.add(question, answer);
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    @RequestMapping("/remove")
    public Question removeQuestion(@RequestParam String question, String answer) {
        var receivedQuestion = new Question(question, answer);
        return service.remove(receivedQuestion);
    }
}
