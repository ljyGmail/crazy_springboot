package com.crazyit.firstboot.domain;

public class Book {
    private Integer id;
    private String title;
    private String cover;
    private String author;
    private Double price;

    public Book() {
    }

    public Book(Integer id, String title, String cover, String author, Double price) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.author = author;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
