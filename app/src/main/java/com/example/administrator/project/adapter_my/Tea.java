package com.example.administrator.project.adapter_my;

public class Tea {
    private int imageId;        //老师图片
    private String name;        //老师名称
    private String grade;       //老师年级
    private String school;      //老师学校
    private String subject;     //老师教导学科
    private String score;       //老师高考分数

    public Tea(int imageId, String name, String grade, String school, String subject, String score) {
        this.imageId = imageId;
        this.name = name;
        this.grade = grade;
        this.school = school;
        this.subject = subject;
        this.score = score;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getSchool() {
        return school;
    }

    public String getSubject() {
        return subject;
    }

    public String getScore() {
        return score;
    }
}
