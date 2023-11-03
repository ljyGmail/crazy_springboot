package com.crazyit.firstboot.ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ch03")
public class Ch03Controller {

    @Autowired
    private WebServerApplicationContext ctx;

    @GetMapping("getServerPort")
    public String getServerPort() {
        return "HTTP端口为: " + ctx.getWebServer().getPort();
    }
}
