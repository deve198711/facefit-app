package com.facefit.yourpackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/blog")
    public String showBlogIndex() {
        return "blog/index";
    }

    @GetMapping("/blog/choosing-sunscreen")
    public String showChoosingSunscreen() {
        return "blog/choosing-sunscreen"; // templates/blog/choosing-sunscreen.html
    }

    @GetMapping("/blog/expensive-sunscreen")
    public String showExpensiveSunscreen() {
        return "blog/expensive-sunscreen"; // templates/blog/expensive-sunscreen.html
    }

    @GetMapping("/blog/rice")
    public String showRice() {
        return "blog/rice"; // templates/blog/rice.html
    }

    @GetMapping("/blog/acne-myth")
    public String acneMythPage() {
        return "blog/acne-myth";
    }
}
