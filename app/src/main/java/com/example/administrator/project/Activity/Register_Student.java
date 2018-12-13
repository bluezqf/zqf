package com.example.administrator.project.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.project.DAO.StudentDAO;
import com.example.administrator.project.R;
import com.example.administrator.project.model.Student;

public class Register_Student extends AppCompatActivity implements View.OnClickListener {

    private Button button1;   //返回按钮
    private Button button2;   //立即注册按钮
    private String account1;  //存储账号
    private String password1; //存储密码
    private String re_password1;  //存储再次输入密码
    private String stu_name1;   //存储学生姓名
    private String tel_number1; //存储电话号码
    private EditText account;   //学生账号
    private EditText password;  //学生密码
    private EditText re_password;   //记住密码
    private EditText stu_name;  //学生姓名
    private EditText tel_number;    //学生电话号码


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__student);

        button1 = findViewById(R.id.back);
        button2 = findViewById(R.id.register);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                Intent intent = new Intent(Register_Student.this,MainActivity.class);
                startActivity(intent);
                Register_Student.this.finish();
                break;
            case R.id.register:
                account = (EditText)findViewById(R.id.account);
                password =  (EditText)findViewById(R.id.password);
                re_password = (EditText) findViewById(R.id.re_password);
                stu_name =  (EditText)findViewById(R.id.student_name);
                tel_number =  (EditText)findViewById(R.id.tel_number);
                account1 = account.getText().toString();
                password1 = password.getText().toString();
                re_password1 = re_password.getText().toString();
                stu_name1 = stu_name.getText().toString();
                tel_number1 = tel_number.getText().toString();

                StudentDAO studentDAO = new StudentDAO(Register_Student.this);

                if (TextUtils.isEmpty(account1)){
                    Toast.makeText(Register_Student.this,"请输入注册账号",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(password1)){
                    Toast.makeText(Register_Student.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(re_password1)){
                    Toast.makeText(Register_Student.this,"请再次输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (!password1.equals(re_password1)){
                    Toast.makeText(Register_Student.this,"两次输入的密码不一样",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(stu_name1)){
                    Toast.makeText(Register_Student.this,"请输入姓名",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(tel_number1)){
                    Toast.makeText(Register_Student.this,"请输入手机号码",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (studentDAO.find(account1) != null){
                    Toast.makeText(Register_Student.this,"该账号已经被注册过了",Toast.LENGTH_SHORT).show();
                }
                else {
                   Student student = new Student(studentDAO.getMaxId()+1,account1,stu_name1,password1,null,
                           null, null,null,null,null, null,
                           null,null,null,tel_number1);
                    studentDAO.add(student);
                    Toast.makeText(Register_Student.this,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Register_Student.this,MainActivity.class);
                    startActivity(intent1);
                }
                break;
            default:
                break;

        }
    }



}
