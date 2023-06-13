package com.jojoldu.webservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    @GetMapping("/")
    public String main() {
        return "main";
    }
}