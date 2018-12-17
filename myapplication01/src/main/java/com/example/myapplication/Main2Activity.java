package com.example.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) {
            showExitGameAlert();
        }
        return super.onKeyDown(keyCode, event);
    }


    //弹出对话框方法
    private void showExitGameAlert() {
        final AlertDialog dlg = new AlertDialog.Builder(this).create();
        dlg.show();
        Window window = dlg.getWindow();
        window.setContentView(R.layout.dialog_layout);
        TextView tv = (TextView) window.findViewById(R.id.tv_no);
        tv.setText("你确定要退出吗");
        LinearLayout ok = (LinearLayout) window.findViewById(R.id.tv_ok);
        //确定按钮
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                exit(); // 退出应用
            }
        });
        //取消按钮
        LinearLayout cancel = (LinearLayout) window.findViewById(R.id.tv_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dlg.cancel();
            }
        });
    }

    //关闭程序
    private void exit() {
        super.finish();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}

