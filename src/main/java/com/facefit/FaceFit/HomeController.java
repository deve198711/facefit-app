package com.facefit.FaceFit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // home.html을 보여줌
    }

    @GetMapping("/quiz")
    public String quizPage() {
        return "quiz"; // quiz.html
    }

    @PostMapping("/result")
    public String showResult(@RequestParam Map<String, String> params, Model model) {
        System.out.println("폼 제출됨!");

        int score = 0;
        for (int i = 1; i <= 9; i++) {
            String answer = params.get("q" + i);
            if (answer != null && !answer.isEmpty()) {
                score += Integer.parseInt(answer);
            }
        }

        String opinion = params.get("q10");
        String skinType;

        if (score <= 16) skinType = "Dry";
        else if (score <= 23) skinType = "Normal";
        else if (score <= 29) skinType = "Combination";
        else skinType = "Oily";

        // 로그 찍기
        System.out.println("score = " + score);
        System.out.println("skinType = " + skinType);
        System.out.println("opinion = " + opinion);

        model.addAttribute("score", score);
        model.addAttribute("skinType", skinType);
        model.addAttribute("opinion", opinion);

        return "result";
    }
}
