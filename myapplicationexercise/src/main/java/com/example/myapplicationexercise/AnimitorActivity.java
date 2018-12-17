package com.example.myapplicationexercise;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.service.carrier.CarrierService;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class AnimitorActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imageView;
    private Button startBtn;
    private Button pauseBtn;
    private Button resumnBtn;
    private ObjectAnimator objectAnimator;


    @SuppressLint("ObjectAnimatorBinding")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animitor);

        bangID();

        objectAnimator =objectAnimator.ofFloat(imageView,"rotation",0f,360f);
        objectAnimator.setDuration(1000);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);



    }

    private void bangID() {

        imageView = findViewById(R.id.animitor_iv);
        startBtn = findViewById(R.id.animitor_start_btn);
        pauseBtn = findViewById(R.id.animitor_pause_btn);
        resumnBtn = findViewById(R.id.animitor_resumn_btn);
        imageView.setOnClickListener(this);
        startBtn.setOnClickListener(this);
        pauseBtn.setOnClickListener(this);
        resumnBtn.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.animitor_start_btn:
                objectAnimator.start();
                break;
            case R.id.animitor_pause_btn:
                objectAnimator.pause();
                break;
            case R.id.animitor_resumn_btn:
                objectAnimator.resume();
                break;
        }

    }
}
