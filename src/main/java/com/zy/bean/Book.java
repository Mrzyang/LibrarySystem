package com.zy.bean;

public class Book {
    private int id;
    private String name;
    private double price;
    private String author;
    private int cateId;
    private String pdate;
    private String img;
    private String description;
    private String detail;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Book(int id, String name, double price, String author, int cateId, String pdate, String img, String description, String detail, String address) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.cateId = cateId;
        this.pdate = pdate;
        this.img = img;
        this.description = description;
        this.detail = detail;
        this.address = address;
    }
}
