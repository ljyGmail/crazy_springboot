package com.crazyit.firstboot.ch03.domain;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class Book {
    @Length(min = 6,max = 30,message = "书名长度必须在6~30个字符之间")
    private String name;
    private MultipartFile  cover;
    private String targetName;

    // 无参数的构造器
    public Book() {
    }

    // 初始化全部成员变量的构造器

    public Book(String name, MultipartFile cover, String targetName) {
        this.name = name;
        this.cover = cover;
        this.targetName = targetName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getCover() {
        return cover;
    }

    public void setCover(MultipartFile cover) {
        this.cover = cover;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
}
