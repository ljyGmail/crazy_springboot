package com.crazyit.firstboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class YamlFkEnvironmentPostProcessor implements EnvironmentPostProcessor {
    // 创建YamlPropertySourceLoader,用于加载YAML文件
    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // 指定自定义的配置文件
        Resource path = new ClassPathResource("fk/fk.yml");
        // 加载自定义的配置文件
        PropertySource<?> ps = null;
        try {
            ps = this.loader.load("custom-resource", path).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("fkjava_yaml.name: " + ps.getProperty("fkjava_yaml.name"));
        System.out.println("fkjava_yaml.age: " + ps.getProperty("fkjava_yaml.age"));
        System.out.println("fkjava_yaml.servers[0]: " + ps.getProperty("fkjava_yaml.servers[0]"));
        System.out.println("fkjava_yaml.servers[1]: " + ps.getProperty("fkjava_yaml.servers[1]"));
        // 将PropertySource中的属性添加到Environment配置环境中
        environment.getPropertySources().addLast(ps);
    }
}
