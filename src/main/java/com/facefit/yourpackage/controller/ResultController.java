package com.facefit.yourpackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ResultController {

    @PostMapping("/result")
    public String processResult(@RequestParam Map<String, String> allParams, Model model) {
        int score = calculateScore(allParams);
        model.addAttribute("score", score);
        model.addAttribute("skinType", determineSkinType(score));
        model.addAttribute("opinion", allParams.getOrDefault("q10", "-"));

        return "result"; // templates/result.html 렌더링
    }

    private int calculateScore(Map<String, String> params) {
        int score = 0;

        for (int i = 1; i <= 9; i++) {  // Q1~Q9 점수 합산, Q10은 의견용
            String answer = params.get("q" + i);
            if (answer != null) {
                try {
                    score += Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    // 숫자 변환 실패 시 무시
                }
            }
        }

        return score;
    }

    private String determineSkinType(int score) {
        if (score >= 9 && score <= 16) {
            return "Dry";
        } else if (score >= 17 && score <= 23) {
            return "Normal";
        } else if (score >= 24 && score <= 29) {
            return "Combination";
        } else if (score >= 30) {
            return "Oily";
        } else {
            return "Unknown";
        }
    }
}
