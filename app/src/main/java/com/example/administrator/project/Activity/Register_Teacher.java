package com.example.administrator.project.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.project.DAO.TeacherDAO;
import com.example.administrator.project.R;
import com.example.administrator.project.model.Teacher;

public class Register_Teacher extends AppCompatActivity implements View.OnClickListener {

    private Button button1;   //返回按钮
    private Button button2;   //立即注册按钮
    private String account;  //存储账号
    private String password; //存储密码
    private String re_password;  //存储再次输入密码
    private String tea_name;   //存储学生姓名
    private String tel_number; //存储电话号码
    private EditText t_account;   //老师账号
    private EditText t_password;  //老师密码
    private EditText t_re_password;   //记住密码
    private EditText teacher_name;  //老师姓名
    private EditText t_tel_number;    //老师电话号码


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__teacher);

        button1 = findViewById(R.id.t_back);
        button2 = findViewById(R.id.t_register);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.t_back:
                Intent intent = new Intent(Register_Teacher.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.t_register:

                t_account = findViewById(R.id.t_account);
                t_password = findViewById(R.id.t_password);
                t_re_password = findViewById(R.id.t_re_password);
                teacher_name = findViewById(R.id.teacher_name);
                t_tel_number = findViewById(R.id.t_tel_number);

                account = t_account.getText().toString();
                password = t_password.getText().toString();
                re_password = t_re_password.getText().toString();
                tea_name = teacher_name.getText().toString();
                tel_number = t_tel_number.getText().toString();

                TeacherDAO teacherDAO = new TeacherDAO(Register_Teacher.this);

                if (TextUtils.isEmpty(account)){
                    Toast.makeText(Register_Teacher.this,"请输入注册账号",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(password)){
                    Toast.makeText(Register_Teacher.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(re_password)){
                    Toast.makeText(Register_Teacher.this,"请再次输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (!password.equals(re_password)){
                    Toast.makeText(Register_Teacher.this,"两次输入的密码不一样",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(tea_name)){
                    Toast.makeText(Register_Teacher.this,"请输入姓名",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(tel_number)){
                    Toast.makeText(Register_Teacher.this,"请输入手机号码",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (teacherDAO.find(account) != null){
                    Toast.makeText(Register_Teacher.this,"该账号已经被注册过了",Toast.LENGTH_SHORT).show();
                }
                else {
                    Teacher teacher = new Teacher(teacherDAO.getMaxId()+1,account,tea_name,password,null,
                            null,null,null,null,null,
                            null,null,tel_number);
                    teacherDAO.add(teacher);
                    Toast.makeText(Register_Teacher.this,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Register_Teacher.this,MainActivity.class);
                    startActivity(intent1);
                }
                break;
            default:
                break;

        }

    }
}
