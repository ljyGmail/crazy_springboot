package com.crazyit.firstboot.app;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class MyConfig {
    // 在容器中配置一个YamlPropertiesFactoryBean
    @Bean
    public YamlPropertiesFactoryBean fkProps(){
        var factory=new YamlPropertiesFactoryBean();
        factory.setResources(new ClassPathResource("fk/fk.yml"));
        return factory;
    }
}
