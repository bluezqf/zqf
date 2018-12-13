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

public class StuAdapter extends ArrayAdapter {

    private int resourceId;

    public StuAdapter(Context context, int textViewResourceId, List<Stu> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Stu stu = (Stu) getItem(position);        //获取当前项的Stu实例
        View view;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        } else {
            view = convertView;
        }
        ImageView stuImage = view.findViewById(R.id.stu_image);
        TextView stuName = view.findViewById(R.id.stu_name);
        TextView stuPrice = view.findViewById(R.id.stu_price);
        TextView stuAddress = view.findViewById(R.id.stu_address);
        TextView stuFrequency = view.findViewById(R.id.stu_frequency);
        stuImage.setImageResource(stu.getImageId());
        stuName.setText(stu.getName());
        stuPrice.setText(stu.getPrice());
        stuAddress.setText(stu.getAddress());
        stuFrequency.setText(stu.getFrequency());
        return view;

        /*ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.stuImage = view.findViewById(R.id.stu_image);
            viewHolder.stuName = view.findViewById(R.id.stu_name);
            viewHolder.stuPrice = view.findViewById(R.id.stu_price);
            viewHolder.stuAddress = view.findViewById(R.id.stu_address);
            viewHolder.stuFrequency = view.findViewById(R.id.stu_frequency);
            view.setTag(viewHolder);        //将ViewHolder存储在View中
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();    //重新获取viewHolder
        }
        assert stu != null;
        viewHolder.stuImage.setImageResource(stu.getImageId());
        viewHolder.stuName.setText(stu.getName());
        viewHolder.stuPrice.setText(stu.getPrice());
        viewHolder.stuAddress.setText(stu.getAddress());
        viewHolder.stuFrequency.setText(stu.getFrequency());
        return view;
    }
    class ViewHolder{
        ImageView stuImage;
        TextView stuName;
        TextView stuPrice;
        TextView stuAddress;
        TextView stuFrequency;
    }*/
    }
}