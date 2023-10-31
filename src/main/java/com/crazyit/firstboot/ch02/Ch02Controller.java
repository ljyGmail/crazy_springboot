package com.crazyit.firstboot.ch02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("ch02")
public class Ch02Controller {

    @GetMapping("outputLoggingToFile")
    public Map<String, Object> outputLoggingToFile() {
        log.trace("------TRACE级别的日志------");
        log.debug("------DEBUG级别的日志------");
        log.info("------INFO级别的日志------");
        log.warn("------WARN级别的日志------");
        log.error("------ERROR级别的日志------");
        return Map.of("hello", "Hello");
    }
}
