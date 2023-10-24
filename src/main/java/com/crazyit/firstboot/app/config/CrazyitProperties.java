package com.crazyit.firstboot.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 指定读取以org.crazyit开头的属性
@ConfigurationProperties(prefix = "org.crazyit", ignoreInvalidFields = false)
@Component
public class CrazyitProperties {
    private boolean enabled;
    private String name;
    private InetAddress remoteAddress;
    private final Item item = new Item();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InetAddress getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(InetAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
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
