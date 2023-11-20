package com.crazyit.firstboot.ch03;

import com.crazyit.firstboot.ch03.domain.User;
import com.crazyit.firstboot.ch03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;

@Controller
public class Ch03Controller {
    // 依赖注入userService组件
    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @PostMapping("/login")
    public String login(User user, Model model, WebRequest webRequest, Locale locale) {
        if (userService.userLogin(user) > 0) {
            model.addAttribute("tip", messageSource.getMessage("success_info", new String[]{user.getUsername()}, locale));
            // 为session添加属性
            webRequest.setAttribute("userName", user.getUsername(), WebRequest.SCOPE_SESSION);
            return "success";
        }
        model.addAttribute("tip", messageSource.getMessage("error_info", null, locale));
        return "fail";
    }
}
