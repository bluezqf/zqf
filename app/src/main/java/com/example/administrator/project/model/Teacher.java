package com.example.administrator.project.model;

public class Teacher {                //老师信息实体类

    private int t_id;                   //存储老师id
    private String t_loginid;              //存储登入账号
    private String t_name;              //存储姓名
    private String t_password;          //存储登入密码
    private String t_sex;               //存储性别
    private String t_grade;             //存储老师的学历
    private String t_subject;           //存储老师能教的学科
    private String t_salary;            //存储老师期望的工资
    private String t_edu_experience;    //存储教育经历
    private String t_major;             //存储专业
    private String t_self_introduction; //存储自我介绍
    private String t_photo;             //存储老师头像
    private String t_telnumber;         //存储老师电话号码
    //定义有参构造函数，用来初始化老师信息实体类中的各个字段    //为属性赋值
    public Teacher(){                   //默认构造函数
        super();
    }

    public Teacher(int t_id,String t_loginid,String t_name,String t_password,String t_sex,String t_grade,
                   String t_subject,String t_salary,String t_edu_experience,String t_major,
                   String t_self_introduction,String t_photo,String t_telnumber){

        this.t_id = t_id;               //为老师id赋值
        this.t_loginid = t_loginid;
        this.t_name = t_name;
        this.t_password = t_password;
        this.t_sex = t_sex;
        this.t_grade = t_grade;
        this.t_subject = t_subject;
        this.t_salary = t_salary;
        this.t_edu_experience = t_edu_experience;
        this.t_major = t_major;
        this.t_self_introduction = t_self_introduction;
        this.t_photo = t_photo;
        this.t_telnumber = t_telnumber;

    }

    public int getT_id() {                      //设置老师id的可读性
        return t_id;
    }

    public void setT_id(int t_id) {             //设置老师id的可写性
        this.t_id = t_id;
    }

    public String getT_loginid() {
        return t_loginid;
    }

    public void setT_loginid(String t_loginid) {
        this.t_loginid = t_loginid;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    public String getT_grade() {
        return t_grade;
    }

    public void setT_grade(String t_grade) {
        this.t_grade = t_grade;
    }

    public String getT_subject() {
        return t_subject;
    }

    public void setT_subject(String t_subject) {
        this.t_subject = t_subject;
    }

    public String getT_salary() {
        return t_salary;
    }

    public void setT_salary(String t_salary) {
        this.t_salary = t_salary;
    }

    public String getT_edu_experience() {
        return t_edu_experience;
    }

    public void setT_edu_experience(String t_edu_experience) {
        this.t_edu_experience = t_edu_experience;
    }

    public String getT_major() {
        return t_major;
    }

    public void setT_major(String t_major) {
        this.t_major = t_major;
    }

    public String getT_self_introduction() {
        return t_self_introduction;
    }

    public void setT_self_introduction(String t_self_introduction) {
        this.t_self_introduction = t_self_introduction;
    }

    public String getT_photo() {
        return t_photo;
    }

    public void setT_photo(String t_photo) {
        this.t_photo = t_photo;
    }

    public String getT_telnumber() {
        return t_telnumber;
    }

    public void setT_telnumber(String t_telnumber){
        this.t_telnumber = t_telnumber;
    }
}
