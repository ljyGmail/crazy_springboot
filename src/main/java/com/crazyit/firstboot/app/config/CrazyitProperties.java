package com.crazyit.firstboot.app.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 指定读取以"org.crazyit"开头的属性
@ConfigurationProperties(prefix = "org.crazyit", ignoreUnknownFields = false)
@Component
@Validated
public class CrazyitProperties {

    @NotEmpty(message = "名字不能为空")
    private String name;

    @Range(max = 150, min = 90, message = "价格必须位于90~150之间")
    private double price;

    @Pattern(regexp = "[1][3-8][0-9]{9}", message = "必须输入有效的手机号")
    private String mobile;

    @Valid
    private final Item item = new Item();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Item getItem() {
        return item;
    }

    public static class Item {

        @Length(min = 5, max = 10, message = "品牌名长度必须为5到10个字符")
        private String brand;
        @Size(min = 1, message = "comments至少包含一个元素")
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
