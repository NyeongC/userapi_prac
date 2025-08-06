package com.ccn.userapi.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String index() {
        return "index"; // templates/index.html 렌더링됨
    }
}
