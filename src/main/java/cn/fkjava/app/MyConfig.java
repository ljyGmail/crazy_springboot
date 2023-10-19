package cn.fkjava.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;

@Configuration
public class MyConfig {

    @Bean
    public DateFormat dateFormat() {
        return DateFormat.getDateInstance();
    }
}
