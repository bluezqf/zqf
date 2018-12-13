package com.example.administrator.project.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.project.FRAGMENT.Fragment_adm;
import com.example.administrator.project.FRAGMENT.Fragment_stu;
import com.example.administrator.project.FRAGMENT.Fragment_tea;
import com.example.administrator.project.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1,button2,button3;

    private Fragment_stu fragment_stu;
    private Fragment_tea fragment_tea;
    private Fragment_adm fragment_adm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new Fragment_stu());

        button1 = findViewById(R.id.student);
        button2 = findViewById(R.id.teacher);
        button3 = findViewById(R.id.admin);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);



    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_main,fragment);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.student:
                if (fragment_stu == null){
                    fragment_stu = new Fragment_stu();
                    replaceFragment(fragment_stu);
                }else {
                    replaceFragment(fragment_stu);
                }
                break;
            case R.id.teacher:
                if (fragment_tea == null){
                    fragment_tea = new Fragment_tea();
                    replaceFragment(fragment_tea);
                }else {
                    replaceFragment(fragment_tea);
                }
                break;
            case R.id.admin:
                if (fragment_adm == null){
                    fragment_adm = new Fragment_adm();
                    replaceFragment(fragment_adm);
                }else {
                    replaceFragment(fragment_adm);
                }
                break;
            default:
                break;

        }

    }
}
