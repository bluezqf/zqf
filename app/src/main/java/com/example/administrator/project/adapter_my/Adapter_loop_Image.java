package com.example.administrator.project.adapter_my;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by 19209 on 2018/9/19.
 */

public class Adapter_loop_Image extends PagerAdapter {
   // private List<Integer>colors = null;
    private List<Integer>image =null;//添加一
    @Override
    public int getCount() {
        //if(colors !=null){
               // return colors.size();}
        if(image !=null){
             return Integer.MAX_VALUE;}

        return 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//重点
        int relposition = position%image.size();
        ImageView imageView = new ImageView((container.getContext()));
        //imageView.setBackgroundColor(colors.get(position));
        imageView.setImageResource(image.get(relposition));//添加一
        //设置完数据以后，就添加到容器里
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    public void setData(List<Integer>image){
        this.image = image;//修改一
    }
}
