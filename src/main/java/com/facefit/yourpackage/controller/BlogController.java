package com.facefit.yourpackage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/blog/choosing-sunscreen")
    public String showBlogPost1() {
        return "blog-post1"; // templates/blog-post1.html 렌더링
    }
}
