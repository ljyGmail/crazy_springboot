package com.crazyit.firstboot.ch02.two;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("ch02")
@Slf4j
public class TwoController {
    @RequestMapping("groupTwo")
    public Map<String, Object> groupTwo() {

        log.trace("------TRACE级别的日志------");
        log.debug("------DEBUG级别的日志------");
        log.info("------INFO级别的日志------");
        log.warn("------WARN级别的日志------");
        log.error("------ERROR级别的日志------");
        return Map.of("two", "Two");
    }
}
