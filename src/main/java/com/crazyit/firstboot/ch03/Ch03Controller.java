package com.crazyit.firstboot.ch03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ch03Controller {

    @GetMapping("crazyit")
    public void hello() {
    }
}
