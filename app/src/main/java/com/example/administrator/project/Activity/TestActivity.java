package com.example.administrator.project.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.project.R;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) ((ActionBar) actionbar).hide();
        button1 = (Button) findViewById(R.id.bt_1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.bt_2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.bt_3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.bt_4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.title_back);
        button5.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_1:
                Intent intent1 = new Intent(TestActivity.this,Test1Activity.class);
                startActivity(intent1);
                break;
            case R.id.bt_2:
                Intent intent2 = new Intent(TestActivity.this,Demo2.class);
                startActivity(intent2);
                break;
            case R.id.bt_3:
                Intent intent3 = new Intent(TestActivity.this,Test3Activity.class);
                startActivity(intent3);
                break;
            case R.id.bt_4:
                Intent intent4 = new Intent(TestActivity.this,Demo4.class);
                startActivity(intent4);
                break;
            case R.id.title_back:
                AlertDialog.Builder dialog = new AlertDialog.Builder(TestActivity.this);
                dialog.setTitle("选择退出");
                dialog.setMessage("您确定退出？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        startActivity(intent);
                    }
                });
                dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                default:
                    break;
        }
    }
}
