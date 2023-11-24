package com.crazyit.firstboot.ch03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {

    @GetMapping("/book/{id}")
    public String viewBook(@PathVariable Integer id) {
        if (id < 0) {
            throw new IllegalArgumentException("被查看图书的id必须大于0");
        }
        return "viewBook";
    }
}
