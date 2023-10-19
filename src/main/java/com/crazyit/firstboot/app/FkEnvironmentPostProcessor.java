package com.crazyit.firstboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class FkEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private final PropertiesPropertySourceLoader loader = new PropertiesPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // 定义自定义的配置文件
        Resource path = new ClassPathResource("fk/fk.properties");
        // 加载自定义的配置文件
        PropertySource<?> ps = loadProperty(path);
        System.out.println("fkjava.name: " + ps.getProperty("fkjava.name"));
        System.out.println("fkjava.age: " + ps.getProperty("fkjava.age"));
        // 将PropertySource中的属性添加到Environment配置环境中
        environment.getPropertySources().addLast(ps);
    }

    private PropertySource<?> loadProperty(Resource path) {
        if (!path.exists()) {
            throw new IllegalArgumentException("资源: " + path + " 不存在");
        }
        try {
            // 加载path对应的配置文件
            return this.loader.load("custom-resource", path).get(0);
        } catch (IOException ex) {
            throw new IllegalStateException("加载配置文件出现错误: " + path, ex);
        }
    }
}
