package com.crazyit.firstboot.ch02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ch02")
public class Ch02Controller {

    @Value("${fkjava.name}")
    private String name;
    @Value("${fkjava.age}")
    private String age;
    @Value("${fkjava.servers[0]}")
    private String server1;
    @Value("${fkjava.servers[1]}")
    private String server2;

    @Value("${crazyit.book.name}")
    private String bookName;
    @Value("${crazyit.book.price}")
    private String bookPrice;

    @GetMapping("extraConfig")
    public String extraConfig() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: " + name);
        sb.append(", age: " + age);
        sb.append(", server1: " + server1);
        sb.append(", server2: " + server2);
        sb.append("<br>");
        sb.append("bookName: " + bookName);
        sb.append(", bookPrice: " + bookPrice);
        return sb.toString();
    }
}
