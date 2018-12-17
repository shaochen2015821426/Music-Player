package com.example.shaoyangyang.shaoshuaih.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shaoyangyang.shaoshuaih.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineFragment extends Fragment {
    private ListView listView1;
    private ListView listView2;
    private ListView listView3;
    private ListView listView4;
    //private  String[] hotMusic = {"1、半壶纱-刘珂唉","2、演员-薛之谦","3、寂寞的人伤心的歌-龙梅子"};
    //private  String[] newMusic = {"1、再见-邓紫棋","2、被风吹散的人们-陈洁仪","3、世界上最难唱的歌-包贝尔"};
   // private  String[] chinaMusic = {"1、半壶纱-刘珂唉","2、演员-薛之谦","3、寂寞的人伤心的歌-龙梅子"};
    private  String[] usaMusic = {"1、See you again-Wiz khalicafa","2、Take me to you heart - shaoshuai","3、Never say never -chaochen"};






    public OnlineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_online, container, false);

        bangID(view);

        //ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,hotMusic);
        //ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,newMusic);
       // ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,chinaMusic);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,usaMusic);

       // listView1.setAdapter(adapter1);
        //listView2.setAdapter(adapter2);
        //listView3.setAdapter(adapter3);
        listView4.setAdapter(adapter4);



        return view;
    }

    private void bangID(View view) {
        //listView1 = view.findViewById(R.id.bfrag_list_lv1);
        //listView2 = view.findViewById(R.id.bfrag_list_lv2);
        //listView3 = view.findViewById(R.id.bfrag_list_lv3);
        listView4 = view.findViewById(R.id.bfrag_list_lv4);
    }

}
