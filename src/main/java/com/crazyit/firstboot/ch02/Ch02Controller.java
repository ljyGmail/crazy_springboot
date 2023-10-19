package com.crazyit.firstboot.ch02;

import org.fkit.app.Bird;
import org.fkit.app.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

@RestController
public class Ch02Controller {

    // 依赖注入容器中的Dog类型的Bean
    @Autowired
    private Dog dog;

    // 依赖注入容器中的Bird类型的Bean
    @Autowired
    private Bird bird;

    // 依赖注入容器中的DateFormat类型的Bean
    @Autowired
    private DateFormat dateFormat;

    @GetMapping("/ch02")
    public String test() {
        return "Hello, " + dog.bark() + ", " +
                bird.fly() + ", " +
                dateFormat.format(new Date());
    }
}
