package com.crazyit.firstboot.ch02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("ch02")
public class Ch02Controller {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("loggingLevelFormat")
    public Map<String, Object> loggingLevelFormat() {

        logger.trace("------TRACE级别的日志------");
        logger.debug("------DEBUG级别的日志------");
        logger.info("------INFO级别的日志------");
        logger.warn("------WARN级别的日志------");
        logger.error("------error级别的日志------");
        return Map.of("hello", "Hello");
    }
}
