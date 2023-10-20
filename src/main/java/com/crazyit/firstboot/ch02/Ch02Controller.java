package com.crazyit.firstboot.ch02;

import org.fkit.app.Bird;
import org.fkit.app.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("ch02")
public class Ch02Controller {

    // 依赖注入容器中的ApplicationArguments Bean
    @Autowired
    private ApplicationArguments args;

    // 依赖注入容器中的Dog类型的Bean
    @Autowired
    private Dog dog;

    // 依赖注入容器中的Bird类型的Bean
    @Autowired
    private Bird bird;

    // 依赖注入容器中的DateFormat类型的Bean
    @Autowired
    private DateFormat dateFormat;

    // 使用@Value注解访问配置属性
    @Value("${fkjava.name}")
    private String name;
    @Value("${fkjava.age}")
    private String age;
    @Value("${fkjava.servers[0]}")
    private String server1;
    @Value("${fkjava.servers[1]}")
    private String server2;

    @GetMapping("beans")
    public String beans() {
        return "Hello, " + dog.bark() + ", " +
                bird.fly() + ", " +
                dateFormat.format(new Date());
    }

    @GetMapping("arguments")
    public String arguments() {
        StringBuilder sb = new StringBuilder();
        sb.append("访问应用的应用参数<br>");
        sb.append("getSourceArgs: " + Arrays.toString(args.getSourceArgs()) + "<br>");
        sb.append("getOptionValues: " + args.getOptionValues("book.name") + "<br>");
        sb.append("getNonOptionArgs: " + args.getNonOptionArgs() + "<br>");
        return sb.toString();
    }

    @GetMapping("jsonConfig")
    public Map<String, String> jsonConfig() {
        return Map.of("名称", name, "年龄", age,
                "服务器1", server1, "服务器2", server2);
    }
}
