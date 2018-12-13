package com.example.administrator.project.adapter_my;

public class Stu {

    private int imageId;         //学生图片
    private String name;        //学生姓名
    private String price;       //学生提出的价格
    private String address;     //学生的地址
    private String frequency;   //学生期望的上课频率

    public Stu(int imageId, String name, String price, String address, String frequency) {
        this.imageId = imageId;
        this.name = name;
        this.price = price;
        this.address = address;
        this.frequency = frequency;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public String getFrequency() {
        return frequency;
    }
}