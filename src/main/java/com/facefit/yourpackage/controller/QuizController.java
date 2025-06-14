package com.facefit.yourpackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {

    @GetMapping("/quiz")
    public String showQuiz() {
        return "quiz"; // templates 폴더 내 quiz.html 렌더링
    }
}
