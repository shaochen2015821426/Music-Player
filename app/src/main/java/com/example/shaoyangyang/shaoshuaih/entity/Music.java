package com.example.shaoyangyang.shaoshuaih.entity;

import android.graphics.Bitmap;

/**
 * Created by shaoyangyang on 2017/12/18.
 */

public class Music {
    /**
     * 在这里所有的属性都是用public修饰的，所以在以后调用时直接调用就可以了
     * 如果用private修饰是需要构建set和get方法
     */
    //歌名
    public String title;
    //歌唱者
    public String artist;
    //专辑名
    public  String album;
    public  int length;
    //专辑图片
    public Bitmap albumBip;
    public String path;
    public boolean isPlaying;
}
