package com.facefit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // templates 폴더 내 home.html 렌더링
    }
    @GetMapping("/home")
    public String showHomePage() {
        return "home"; // https://facefit.life/home
    }

}
