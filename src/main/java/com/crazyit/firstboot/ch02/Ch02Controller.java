package com.crazyit.firstboot.ch02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("ch02")
public class Ch02Controller {
    // 使用@Value注解访问属性配置属性
    @Value("${fkjava.secret}")
    private String secret;
    @Value("${fkjava.number}")
    private String number;
    @Value("${fkjava.bignumber}")
    private String bignumber;
    @Value("${fkjava.uuid}")
    private String uuid;
    @Value("${fkjava.number-less-than-ten}")
    private String numberLessThanTen;
    @Value("${fkjava.number-in-range}")
    private String numberInRange;

    @GetMapping("configRandomValue")
    public Map<String, String> configRandomValue() {
        return Map.of("secret", secret,
                "bignumber", bignumber,
                "uuid", uuid,
                "numberLessThanTen", numberLessThanTen,
                "numberInRange", numberInRange
        );
    }
}
