package com.crazyit.firstboot.config;

import com.crazyit.firstboot.domain.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    // @ConfigurationProperties注解会驱动Spring自动调用该Bean的setter方法
    @ConfigurationProperties("fkjava.person")
    public Person person() {
        return new Person();
    }
}
