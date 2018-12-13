package com.example.administrator.project.adapter_my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.project.R;

import java.util.List;

public class TeaAdapter extends ArrayAdapter {

    private int resourceId;

    public TeaAdapter(Context context, int textViewResourceId, List<Tea> objects) {
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tea tea = (Tea) getItem(position);        //获取当前项的Tea实例
        View view ;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else {
            view = convertView;
        }

        ImageView teaImage = view.findViewById(R.id.tea_image);
        TextView teaName = view.findViewById(R.id.tea_name);
        TextView teaGrade = view.findViewById(R.id.tea_grade);
        TextView teaSchool = view.findViewById(R.id.tea_school);
        TextView teaSubject = view.findViewById(R.id.tea_subject);
        TextView teaScore = view.findViewById(R.id.tea_score);

        teaImage.setImageResource(tea.getImageId());
        teaName.setText(tea.getName());
        teaGrade.setText(tea.getGrade());
        teaSchool.setText(tea.getSchool());
        teaSubject.setText(tea.getSubject());
        teaScore.setText(tea.getScore());
        return view;
    }
}
