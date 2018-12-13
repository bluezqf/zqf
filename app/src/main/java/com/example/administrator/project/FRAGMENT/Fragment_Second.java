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
import com.example.administrator.project.adapter_my.Tea;
import com.example.administrator.project.adapter_my.TeaAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Second extends Fragment {

    private List<Tea> teaList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initTeas();         //初始化老师数据
        TeaAdapter adapter = new TeaAdapter(getActivity(),R.layout.simple_item,teaList);
        ListView listView = getActivity().findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

    private void initTeas() {
        for (int i = 0; i < 4; i++){
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
}
