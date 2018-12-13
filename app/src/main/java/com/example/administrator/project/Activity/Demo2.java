package com.example.administrator.project.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.project.R;
import com.example.administrator.project.adapter_my.Fruit;
import com.example.administrator.project.adapter_my.FruitAdapter;

import java.util.ArrayList;
import java.util.List;

public class Demo2 extends AppCompatActivity {
    /*private String[] data = {"1","2","3","4","5","1","2","3","4","5",
            "1","2","3","4","5",};*/
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(Demo2.this,
                android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);*/
        initFruits();
        FruitAdapter adapter = new FruitAdapter(Demo2.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(Demo2.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for (int i = 0;i<3;i++){
            Fruit a = new Fruit("江会文A",R.drawable.photo);
            fruitList.add(a);
            Fruit b = new Fruit("江会文B",R.drawable.photo);
            fruitList.add(b);
            Fruit c = new Fruit("江会文C",R.drawable.photo);
            fruitList.add(c);
            Fruit d = new Fruit("江会文D",R.drawable.photo);
            fruitList.add(d);
            Fruit e = new Fruit("江会文E",R.drawable.photo);
            fruitList.add(e);

        }
    }
}
