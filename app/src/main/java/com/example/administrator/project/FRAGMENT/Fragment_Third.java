package com.example.administrator.project.FRAGMENT;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.project.R;
import com.example.administrator.project.adapter_my.Stu;
import com.example.administrator.project.adapter_my.StuAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Third extends Fragment {

    private List<Stu> stuList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initStu();          //初始化学生的数据
        StuAdapter adapter = new StuAdapter(getActivity(),R.layout.simple_stu_item,stuList);
        ListView listView = getActivity().findViewById(R.id.list_view_third);
        listView.setAdapter(adapter);
    }

    private void initStu() {
        for (int i = 0 ; i<5; i++){
            Stu a = new Stu(R.drawable.chinese,"周女士","可以面谈","地铁大厦附近",
                    "一周三次");
            stuList.add(a);
            Stu b = new Stu(R.drawable.math,"杨先生","面议","万达华府",
                    "一周五次");
            stuList.add(b);
            Stu c = new Stu(R.drawable.chinese,"李女士","30","地铁大厦附近",
                    "一周七次");
            stuList.add(c);
            Stu d = new Stu(R.drawable.english,"张先生","30","瑶湖西",
                    "一周一次");
        }

    }
}
