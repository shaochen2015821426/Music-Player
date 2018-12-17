package com.example.shaoyangyang.shaoshuaih.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/**
 * Created by shaoyangyang on 2017/12/20.
 */

public class MergeImage {
        /**
         * 合成碟片图片
         *
         * @param discBitmap  黑胶碟片底图
         * @param albumBitmap 专辑封面图
         * @return
         */
        public static Bitmap mergeThumbnailBitmap(Bitmap discBitmap, Bitmap albumBitmap) {

            //获得黑胶碟片底图宽和高
            int w = discBitmap.getWidth();
            int h = discBitmap.getHeight();
            //根据黑胶碟片底图的宽和高，对专辑图片进行缩放
            albumBitmap = Bitmap.createScaledBitmap(albumBitmap, w, h, true);
            Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bm);
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            //这里需要先画出一个圆
            canvas.drawCircle(w / 2, h / 2, w / 3 +10, paint);
            //圆画好之后将画笔重置一下
            paint.reset();
            //设置图像合成模式，该模式为只在源图像和目标图像相交的地方绘制源图像
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(albumBitmap, 0, 0, paint);
            paint.reset();
            canvas.drawBitmap(discBitmap, 0, 0, null);
            return bm;
        }
    }