package com.example.administrator.project.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.project.FRAGMENT.Fragment_Fifth;
import com.example.administrator.project.FRAGMENT.Fragment_First;
import com.example.administrator.project.FRAGMENT.Fragment_Fourth;
import com.example.administrator.project.FRAGMENT.Fragment_Second;
import com.example.administrator.project.FRAGMENT.Fragment_Third;
import com.example.administrator.project.R;

public class Test1Activity extends AppCompatActivity implements View.OnClickListener{
    private Button bt1;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;

    private Fragment_First fg1;
    private Fragment_Second fg2;
    private Fragment_Third fg3;
    private Fragment_Fourth fg4;
    private Fragment_Fifth fg5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        replaceFragment(new Fragment_First());
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) ((ActionBar) actionbar).hide();
        bt1 = (Button) findViewById(R.id.title_back);
        bt1.setOnClickListener(this);
        img1 = (ImageView) findViewById(R.id.butt_1);
        img2 = (ImageView) findViewById(R.id.butt_2);
        img3 = (ImageView) findViewById(R.id.butt_3);
        img4 = (ImageView) findViewById(R.id.butt_4);
        img5 = (ImageView) findViewById(R.id.butt_5);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);

    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_page,fragment);
        ft.commitAllowingStateLoss();
    }
    public void changeImage(int i){
        switch (i){
            case 1:
                img1.setImageResource(R.drawable.index_click);
                img2.setImageResource(R.drawable.teacher);
                img3.setImageResource(R.drawable.student);
                img4.setImageResource(R.drawable.chat);
                img5.setImageResource(R.drawable.mydata);
                break;
            case 2:
                img1.setImageResource(R.drawable.index);
                img2.setImageResource(R.drawable.teacher_click);
                img3.setImageResource(R.drawable.student);
                img4.setImageResource(R.drawable.chat);
                img5.setImageResource(R.drawable.mydata);
                break;
            case 3:
                img1.setImageResource(R.drawable.index);
                img2.setImageResource(R.drawable.teacher);
                img3.setImageResource(R.drawable.student_click);
                img4.setImageResource(R.drawable.chat);
                img5.setImageResource(R.drawable.mydata);
                break;
            case 4:
                img1.setImageResource(R.drawable.index);
                img2.setImageResource(R.drawable.teacher);
                img3.setImageResource(R.drawable.student);
                img4.setImageResource(R.drawable.chat_click);
                img5.setImageResource(R.drawable.mydata);
                break;
            case 5:
                img1.setImageResource(R.drawable.index);
                img2.setImageResource(R.drawable.teacher);
                img3.setImageResource(R.drawable.student);
                img4.setImageResource(R.drawable.chat);
                img5.setImageResource(R.drawable.mydata_click);
        }
    }
    @Override
    public void onClick(View v){
        int change = 0;
        switch (v.getId()){
            case R.id.title_back:
                Intent intent = new Intent(Test1Activity.this,TestActivity.class);
                startActivity(intent);
                break;
            case R.id.butt_1:
                change = 1; changeImage(change);
                if (fg1 == null){
                    fg1 = new Fragment_First();
                    replaceFragment(fg1);
                }else {
                    replaceFragment(fg1);
                }
                break;
            case R.id.butt_2:
                change = 2; changeImage(change);
                if (fg2 == null){
                    fg2 = new Fragment_Second();
                    replaceFragment(fg2);
                }else {
                    replaceFragment(fg2);
                }
                break;
            case R.id.butt_3:
                change = 3; changeImage(change);
                if (fg3 == null){
                    fg3 = new Fragment_Third();
                    replaceFragment(fg3);
                }else {
                    replaceFragment(fg3);
                }
                break;
            case R.id.butt_4:
                change = 4; changeImage(change);
                if (fg4 == null){
                    fg4 = new Fragment_Fourth();
                    replaceFragment(fg4);
                }else {
                    replaceFragment(fg4);
                }
                break;
            case R.id.butt_5:
                change = 5; changeImage(change);
                if (fg5 == null){
                    fg5 = new Fragment_Fifth();
                }else {
                    replaceFragment(fg5);
                }
                break;
            default:
                break;
        }
    }
}
