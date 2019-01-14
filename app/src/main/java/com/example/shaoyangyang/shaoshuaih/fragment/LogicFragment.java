package com.example.shaoyangyang.shaoshuaih.fragment;


import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.shaoyangyang.shaoshuaih.MusicActivity;
import com.example.shaoyangyang.shaoshuaih.R;
import com.example.shaoyangyang.shaoshuaih.adapter.MusicAdapter;
import com.example.shaoyangyang.shaoshuaih.entity.Music;
import com.example.shaoyangyang.shaoshuaih.utils.Common;
import com.master.permissionhelper.PermissionHelper;

import java.util.List;

/**
 * A simple {@link Fragment} subclass
 */

public class LogicFragment extends Fragment {

    private String TAG = "HelloActivity";                                       //下面两个属性和获取mediadatabase的权限有关系，可查阅代码块下的链接
    private PermissionHelper permissionHelper;
    private ListView listView;                                                          //创建ListView的对象
    private List<Music> musicList;                                                          //将Music放入List集合中，并实例化List<Music>
    private List<ListView> listViewList;
    private MusicAdapter adapter;

    public LogicFragment() {
        // Required empty public constructor
    }

    //LoginFrangment中的onCreate()方法
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_logic, container, false);        //创建View对象，返回view

// 关于权限的代码
        permissionHelper = new PermissionHelper(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        permissionHelper.request(new PermissionHelper.PermissionCallback() {
            @Override
            public void onPermissionGranted() {
                initListView();                                          //获取权限后扫描数据库获取信息
                Log.d(TAG, "onPermissionGranted() called");
            }

            @Override
            public void onIndividualPermissionGranted(String[] grantedPermission) {
                Log.d(TAG, "onIndividualPermissionGranted() called with: grantedPermission = [" + TextUtils.join(",", grantedPermission) + "]");
            }

            @Override
            public void onPermissionDenied() {
                Log.d(TAG, "onPermissionDenied() called");
            }

            @Override
            public void onPermissionDeniedBySystem() {
                Log.d(TAG, "onPermissionDeniedBySystem() called");
            }
        });
// 权限代码结束


        //对Listview进行监听
        listView = view.findViewById(R.id.logic_lv);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {             //将listView的每一个item实现监听
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (Music m : Common.musicList
                        ) {
                    m.isPlaying = false;
                }
                Common.musicList.get(position).isPlaying = true;
                //更新界面
                adapter.notifyDataSetChanged();
                //intent实现页面的跳转，getActivity()获取当前的activity， MusicActivity.class将要调转的activity
                Intent intent = new Intent(getActivity(), MusicActivity.class);
                //使用putExtra（）传值
                intent.putExtra("position", position);
                startActivity(intent);

                PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                RemoteViews remoteViews = new RemoteViews(getActivity().getPackageName(), R.layout.notification_layout);
                remoteViews.setTextViewText(R.id.nf_title_tv, Common.musicList.get(position).title);
                remoteViews.setTextViewText(R.id.nf_artist_tv, Common.musicList.get(position).artist);
                if (Common.musicList.get(position).albumBip != null) {
                    remoteViews.setImageViewBitmap(R.id.nf_album_imgv, Common.musicList.get(position).albumBip);
                }
                //通知
                Notification.Builder builder = new Notification.Builder(getActivity());
                builder.setContent(remoteViews);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                builder.setContentTitle("我的通知");
                builder.setContentText("正在播放音乐");
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);

                NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1, builder.build());

            }
        });

        adapter = new MusicAdapter(getActivity(), musicList);                //创建MusicAdapter的对象，实现自定义适配器的创建
        listView.setAdapter(adapter);                                                 //listView绑定适配器
        return view;
    }

    // 权限代码
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (permissionHelper != null) {
            permissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
// 权限代码结束

    //nitListView()实现对手机中MediaDataBase的扫描
    private void initListView() {
        Common.musicList.clear();
        //获取ContentResolver的对象，并进行实例化
        ContentResolver resolver = getActivity().getContentResolver();
        //获取游标
        Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER); //创建游标MediaStore.Audio.Media.EXTERNAL_CONTENT_URI获取音频的文件，后面的是关于select筛选条件，这里填土null就可以了
        //游标归零
        if(cursor.moveToFirst()){
            do {
                String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));            //获取歌名
                String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));         //获取歌唱者
                String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));           //获取专辑名
                int albumID = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));            //获取专辑图片id
                int length = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                //创建Music对象，并赋值
                Music music = new Music();
                music.length = length;
                music.title = title;
                music.artist = artist;
                music.album = album;
                music.path = path;
                music.albumBip = getAlbumArt(albumID);
                //将music放入musicList集合中
                Common.musicList.add(music);
            }  while (cursor.moveToNext());
        }else {
            Toast.makeText(getActivity(), "本地没有音乐哦", Toast.LENGTH_SHORT).show();
        }
        cursor.close();                                                                         //关闭游标
    }

    //获取专辑图片的方法
    private Bitmap getAlbumArt(int album_id) {                              //前面我们只是获取了专辑图片id，在这里实现通过id获取掉专辑图片
        String mUriAlbums = "content://media/external/audio/albums";
        String[] projection = new String[]{"album_art"};
        Cursor cur = getActivity().getContentResolver().query(Uri.parse(mUriAlbums + "/" + Integer.toString(album_id)), projection, null, null, null);
        String album_art = null;
        if (cur.getCount() > 0 && cur.getColumnCount() > 0) {
            cur.moveToNext();
            album_art = cur.getString(0);
        }
        cur.close();
        Bitmap bm = null;
        if (album_art != null) {
            bm = BitmapFactory.decodeFile(album_art);
        } else {
            bm = BitmapFactory.decodeResource(getResources(), R.mipmap.touxiang1);
        }
        return bm;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

}
