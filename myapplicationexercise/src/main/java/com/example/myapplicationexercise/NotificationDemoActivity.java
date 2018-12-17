package com.example.myapplicationexercise;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationDemoActivity extends AppCompatActivity {

    private Button nfBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);

        nfBtn = findViewById(R.id.nf_btn);

        nfBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Notification.Builder builder = new Notification.Builder(NotificationDemoActivity.this);
                builder.setContentTitle("通知");
                builder.setContentText("我饿了，你可知道");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(1,builder.build());
            }
        });
    }
}
