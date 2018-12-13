package com.example.administrator.project.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;          //定义数据库版本
    private static final String DBNAME = "account.db";        //定义数据库名

    public  DBOpenHelper(Context context){           //定义构造函数
        super(context,DBNAME,null,VERSION);     //重写基类的构造函数
    }
    @Override
    public void onCreate(SQLiteDatabase db) {             //创建数据库
        db.execSQL("create table teacher(t_id int primary key,t_loginid varchar(20),t_name varchar(10),t_password varchar(20)," +
                "t_sex varchar(10),t_grade varchar(50),t_sorce_gaokao varchar(10),t_subject varchar(50)," +
                "t_salary varchar(20),t_edu_experience varchar(100),t_major varchar(20)," +
                "t_self_introduction varchar(200),t_photo varchar(50)," +
                "t_telnumber varchar(11))");           //创建teacher表
        db.execSQL("create table student(s_id int primary key,s_loginid varchar(20),s_name varchar(10),s_password varchar(20)," +
                "s_sex varchar(10),s_grade varchar(20),s_price varchar(20),s_frequency varchar(20)," +
                "s_address varchar(100),s_basics varchar(20),s_require_sex varchar(10),s_require_grade varchar(50)," +
                "s_self_introduction varchar(200),s_photo varchar(50)," +
                "s_telnumber varchar(11))");       //创建student表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
