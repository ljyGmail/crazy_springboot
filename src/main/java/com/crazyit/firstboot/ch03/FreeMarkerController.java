package com.crazyit.firstboot.ch03;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class FreeMarkerController {

    @PostMapping("/login")
    public String login(String username, String pass, Model model, WebRequest webReq, HttpSession session) {
        if (username.equals("crazyit.org") && pass.equals("ljy")) {
            webReq.setAttribute("name", username, webReq.SCOPE_SESSION);
            webReq.setAttribute("role", "manager", webReq.SCOPE_SESSION);
//            session.setAttribute("name",username);
//            session.setAttribute("role","manager");
            return "main";
        }
        model.addAttribute("error", "用户名/密码不匹配");
        return "index";
    }
}
