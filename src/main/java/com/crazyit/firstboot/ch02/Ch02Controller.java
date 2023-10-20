package com.crazyit.firstboot.ch02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("ch02")
public class Ch02Controller {

    @Value("${app.description}")
    private String appDescription;
    @Value("${book.description}")
    private String bookDescription;

    @GetMapping("usingPlaceholder")
    public Map<String, String> usingPlaceholder() {
        return Map.of("应用描述: ", appDescription, "图书描述: ", bookDescription);
    }
}
