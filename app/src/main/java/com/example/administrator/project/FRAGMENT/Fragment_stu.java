package com.example.administrator.project.FRAGMENT;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.project.Activity.Register_Student;
import com.example.administrator.project.Activity.Test1Activity;
import com.example.administrator.project.DAO.StudentDAO;
import com.example.administrator.project.R;

public class Fragment_stu extends Fragment {

    private Button button1;   //学生注册按钮
    private Button button2;   //学生登入按钮

    private EditText Account;   //学生输入的账号
    private EditText Password;  //学生输入的密码

    private String account;     //存储学生账号
    private String password;    //存储学生密码

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stu,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button1 = getActivity().findViewById(R.id.fra_stu_register);
        button2 = getActivity().findViewById(R.id.fra_stu_login);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Register_Student.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Account = getActivity().findViewById(R.id.fra_stu_account);
                Password = getActivity().findViewById(R.id.fra_stu_password);
                account = Account.getText().toString();
                password = Password.getText().toString();

                StudentDAO studentDAO= new StudentDAO(getActivity());
                if (TextUtils.isEmpty(account)){
                    Toast.makeText(getActivity(),"请输入登入账号",Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(password)){
                    Toast.makeText(getActivity(),"请输入密码",Toast.LENGTH_SHORT).show();
                }
                else if (studentDAO.find(account) == null){
                    Toast.makeText(getActivity(),"该账号没有被注册",Toast.LENGTH_SHORT).show();
                }
                else if (!studentDAO.find(account).getS_password().equals(password)){
                    Toast.makeText(getActivity(),"密码错误",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(),"登入成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(),Test1Activity.class);
                    startActivity(intent);
                }

            }
        });
    }


}
