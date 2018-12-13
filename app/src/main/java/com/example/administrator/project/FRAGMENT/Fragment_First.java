package com.example.administrator.project.FRAGMENT;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.ListView;

import com.example.administrator.project.R;
import com.example.administrator.project.adapter_my.Adapter_loop_Image;
import com.example.administrator.project.adapter_my.Tea;
import com.example.administrator.project.adapter_my.TeaAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_First extends Fragment {

    private ViewPager loopPager;
    private Adapter_loop_Image adapter_loop_image;
    private Handler handler;

    private List<Tea> teaList = new ArrayList<>();

    // private static List<Integer> colors = new ArrayList<>();

    private static List<Integer> image = new ArrayList<>();
    static {
        image.add( R.drawable.index_roll1);
        image.add( R.drawable.index_roll2);
        image.add( R.drawable.index_roll3);
        image.add( R.drawable.index_roll4);
        image.add( R.drawable.index_roll5);

    }
    int[] imageIds = new int[]{
            R.drawable.index_roll1,R.drawable.index_roll2,
            R.drawable.index_roll3,R.drawable.index_roll4,
            R.drawable.index_roll5};
    private AdapterViewFlipper flipper;
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        handler = new Handler();//自动轮播
    }


    private Runnable looperTask = new Runnable() {
        @Override
        public void run() {
            //切换viewPager里面的图片
            int currentItem =loopPager.getCurrentItem();
            loopPager.setCurrentItem(++currentItem,false);
            handler.postDelayed(this,1000);
        }
    };

    //初始化
    private void initview(){
        //第一步，就是找到这个Viewpager控件
        loopPager = getView().findViewById(R.id.loop_image_pager);
        //第二步，设置适配器
        adapter_loop_image = new Adapter_loop_Image();
        adapter_loop_image.setData(image);//添加一
        loopPager.setAdapter(adapter_loop_image);

        initTeas();         //初始化老师数据
        TeaAdapter adapter = new TeaAdapter(getActivity(),R.layout.simple_tea_item,teaList);
        ListView listView = getActivity().findViewById(R.id.my_list);
        listView.setAdapter(adapter);

    }

    private void initTeas() {
        Tea chen = new Tea(R.drawable.chen,"陈老师","大三","江西师范大学",
                "历史 政治","高考720分");
        teaList.add(chen);
        Tea huang = new Tea(R.drawable .huang,"黄老师","大三","江西师范大学",
                "语文 政治","高考750分");
        teaList.add(huang);
        Tea fu = new Tea(R.drawable.fu,"付老师","大二","江西师范大学",
                "数学 英语 语文","高考750分");
        teaList.add(fu);
        Tea zhang = new Tea(R.drawable.zhang,"张老师","大三","江西师范大学",
                "物理 化学 数学","高考749分");
        teaList.add(zhang);
        Tea ge = new Tea(R.drawable.ge,"葛老师","大三","江西师范大学",
                "英语","高考749分");
        Tea jiang = new Tea(R.drawable.photo,"江老师","大三","江西师范大学",
                "英语 生物 化学","高考720分");
        teaList.add(jiang);
        Tea shi = new Tea(R.drawable.shi,"史老师","大四","江西师范大学",
                "数学 政治 历史","高考666分");
        teaList.add(shi);
        Tea zhi = new Tea(R.drawable.zhi,"智老师","大一","江西师范大学",
                "数学 英语 语文","高考666分");
        teaList.add(zhi);
    }
}
