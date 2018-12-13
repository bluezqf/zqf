package com.example.administrator.project.model;

public class Student {                      //学生信息实体类

    private int s_id;                       //存储学生id
    private String s_loginid;                  //存储学生登入账号
    private String s_name;                  //存储姓名
    private String s_password;              //存储密码
    private String s_sex;                   //性别
    private String s_grade;                 //学生的年级
    private String s_price;                //学生想要的价格
    private String s_frequency;             //上课的频率
    private String s_address;               //学生的地址
    private String s_basics;                //学生的基础
    private String s_require_sex;           //学生对老师的性别要求
    private String s_require_grade;         //学生对老师的学历要求
    private String s_self_introduction;     //学生自我介绍
    private String s_photo;                 //学生的头像
    private String s_telnumber;             //学生的联系电话

    public Student(){                   //默认构造函数
        super();
    }

    public Student(int s_id, String s_loginid, String s_name, String s_password, String s_sex, String s_grade,
                   String s_price, String s_frequency, String s_address, String s_basics,
                   String s_require_sex, String s_require_grade, String s_self_introduction,
                   String s_photo, String s_telnumber) {
        //定义有参构造函数，用来初始化学生信息实体类中的各个字段
        this.s_id = s_id;                   //为学生id赋值
        this.s_loginid = s_loginid;
        this.s_name = s_name;
        this.s_password = s_password;
        this.s_sex = s_sex;
        this.s_grade = s_grade;
        this.s_price = s_price;
        this.s_frequency = s_frequency;
        this.s_address = s_address;
        this.s_basics = s_basics;
        this.s_require_sex = s_require_sex;
        this.s_require_grade = s_require_grade;
        this.s_self_introduction = s_self_introduction;
        this.s_photo = s_photo;
        this.s_telnumber = s_telnumber;
        //为属性赋值
    }

    public int getS_id() {                      //设置学生id的可读性
        return s_id;
    }

    public void setS_id(int s_id) {             //设置学生id的可写性
        this.s_id = s_id;
    }

    public String getS_loginid() {
        return s_loginid;
    }

    public void setS_loginid(String s_loginid) {
        this.s_loginid = s_loginid;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getS_grade() {
        return s_grade;
    }

    public void setS_grade(String s_grade) {
        this.s_grade = s_grade;
    }

    public String getS_price() {
        return s_price;
    }

    public void setS_price(String s_price) {
        this.s_price = s_price;
    }

    public String getS_frequency() {
        return s_frequency;
    }

    public void setS_frequency(String s_frequency) {
        this.s_frequency = s_frequency;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getS_basics() {
        return s_basics;
    }

    public void setS_basics(String s_basics) {
        this.s_basics = s_basics;
    }

    public String getS_require_sex() {
        return s_require_sex;
    }

    public void setS_require_sex(String s_require_sex) {
        this.s_require_sex = s_require_sex;
    }

    public String getS_require_grade() {
        return s_require_grade;
    }

    public void setS_require_grade(String s_require_grade) {
        this.s_require_grade = s_require_grade;
    }

    public String getS_self_introduction() {
        return s_self_introduction;
    }

    public void setS_self_introduction(String s_self_introduction) {
        this.s_self_introduction = s_self_introduction;
    }

    public String getS_photo() {
        return s_photo;
    }

    public void setS_photo(String s_photo) {
        this.s_photo = s_photo;
    }

    public String getS_telnumber() {
        return s_telnumber;
    }

    public void setS_telnumber(String s_telnumber) {
        this.s_telnumber = s_telnumber;
    }
}
