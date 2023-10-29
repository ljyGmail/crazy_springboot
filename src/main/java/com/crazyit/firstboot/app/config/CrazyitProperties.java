package com.crazyit.firstboot.app.config;

import com.crazyit.firstboot.domain.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties("crazyit")
@Component
public class CrazyitProperties {
    private final List<Person> list = new ArrayList<>();
    private final Map<String, Person> map =new HashMap<>();

    public List<Person> getList() {
        return list;
    }

    public Map<String, Person> getMap() {
        return map;
    }
}
