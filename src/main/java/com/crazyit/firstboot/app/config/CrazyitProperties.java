package com.crazyit.firstboot.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ConfigurationProperties(prefix = "org.crazyit", ignoreUnknownFields = false)
public class CrazyitProperties {
    private boolean enabled;
    private String name;
    private InetAddress remoteAddress;
    private final Item item;

    // 指定使用构造器执行属性值注入
    public CrazyitProperties(boolean enabled, String name,
                             InetAddress remoteAddress, Item item) {
        this.enabled = enabled;
        this.name = name;
        this.remoteAddress = remoteAddress;
        this.item = item;
    }

    // 只需定义getter方法，无须定义setter方法
    public boolean isEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    public InetAddress getRemoteAddress() {
        return remoteAddress;
    }

    public Item getItem() {
        return item;
    }

    public static class Item {
        private String brand;
        private List<String> comments = new ArrayList<>(Collections.singleton("GREAT"));

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public List<String> getComments() {
            return comments;
        }

        public void setComments(List<String> comments) {
            this.comments = comments;
        }
    }
}
