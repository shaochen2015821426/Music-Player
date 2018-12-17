package com.example.shaoyangyang.shaoshuaih.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shaoyangyang.shaoshuaih.R;
import com.example.shaoyangyang.shaoshuaih.entity.Music;
import com.example.shaoyangyang.shaoshuaih.utils.Common;

import java.util.List;

/**
 * Created by shaoyangyang on 2017/12/18.
 */
//继承BaseAdapter 实现自定义适配器，复写BaseAdapter的代码
public class MusicAdapter extends BaseAdapter {
    //定义两个属性，用List集合存放Music类
    private Context context;
    private List<Music> musicList;

    //创建MusicAdapter的构造方法，在LogicFragment需要调用MusicAdapter的构造方法来创建适配器
    public MusicAdapter(Context context, List<Music> musicList) {
        this.context = context;
        this.musicList = musicList;

    }

    //这里需要返回musicList.size()
    @Override
    public int getCount() {
        return Common.musicList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //在getView（）方法中是实现对模板的绑定，赋值
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //声明View和ViewHolder的对象
        View view = null;
        ViewHolder viewHolder = null;
        //缓存原理，程序运行到这里判断convertView是否为空
        if (convertView == null) {
            //绑定行布局文件，就是绑定我们需要适配的模板
            view = LayoutInflater.from(context).inflate(R.layout.music_item, null);
            //实例化ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.titleTv = view.findViewById(R.id.musicitem_title_tv);
            viewHolder.artistTv = view.findViewById(R.id.musicitem_artist_tv);
            viewHolder.albumImgv = view.findViewById(R.id.musicitem_album_imgv);
            viewHolder.isPlayingView = view.findViewById(R.id.musicitem_playing_v);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        //赋值 准确的是绑定赋值的中介
        viewHolder.titleTv.setText(Common.musicList.get(position).title);
        viewHolder.artistTv.setText(Common.musicList.get(position).artist + "-" + Common.musicList.get(position).album);
        viewHolder.albumImgv.setImageBitmap(Common.musicList.get(position).albumBip);
        if (Common.musicList.get(position).isPlaying) {
            viewHolder.isPlayingView.setVisibility(View.VISIBLE);
        } else {
            viewHolder.isPlayingView.setVisibility(View.INVISIBLE);
        }

        return view;
    }

    //创建一个类ViewHolder，用来存放music_item.xml中的控件
    class ViewHolder {
        TextView titleTv;
        TextView artistTv;
        ImageView albumImgv;
        View isPlayingView;
    }
}
