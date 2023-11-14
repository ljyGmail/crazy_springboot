package com.crazyit.firstboot.ch03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {

    @PostMapping("/login")
    public String login(String username, String pass, Model model, WebRequest webReq) {
        if (username.equals("crazyit.org") && pass.equals("ljy")) {
            webReq.setAttribute("name", username, WebRequest.SCOPE_SESSION);
            webReq.setAttribute("role", "manager", WebRequest.SCOPE_SESSION);
            return "main";
        }
        model.addAttribute("error", "用户名/密码不匹配");
        return "index";
    }

    @GetMapping("/viewBooks")
    public void viewBooks(Model model) {
        List<Map<String, Object>> bookList = new ArrayList<>();
        Map<String, Object> bookOne = new HashMap<>();
        bookOne.put("title", "Spring Boot终极讲义");
        bookOne.put("author", "李刚");
        bookOne.put("price", 105);
        bookOne.put("cover", "one.png");
        Map<String, Object> bookTwo = new HashMap<>();
        bookTwo.put("title", "Pandas in Action");
        bookTwo.put("author", "Boris Paskhaver");
        bookTwo.put("price", 67);
        bookTwo.put("cover", "two.png");

        bookList.add(bookOne);
        bookList.add(bookTwo);

        model.addAttribute("bookList", bookList);
    }
}
