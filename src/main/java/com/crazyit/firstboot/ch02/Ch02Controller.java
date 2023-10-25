package com.crazyit.firstboot.ch02;

import com.crazyit.firstboot.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ch02")
public class Ch02Controller {
    private final Person person;

    @Autowired
    public Ch02Controller(Person person) {
        this.person = person;
    }

    @GetMapping("configPropsForBean")
    public Person configPropsForBean() {
        return person;
    }
}
