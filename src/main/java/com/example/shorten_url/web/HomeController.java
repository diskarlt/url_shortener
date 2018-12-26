package com.example.shorten_url.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        log.info("someone visit");
        return "index";
    }

    @RequestMapping("/hello")
    public @ResponseBody
    String hello() {
        log.info("someone hello");
        return "Hello, Spring Boot!";
    }
}