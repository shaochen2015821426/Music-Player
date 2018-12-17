package com.example.myapplicationexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AActivity extends AppCompatActivity {

    private TextView aBtn;
    private String TAG = "AActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        aBtn = findViewById(R.id.a_btn);

        aBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this,BActivity.class);
                AActivity.this.startActivity(intent);
            }
        });

        Log.e(TAG,"onCreate$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"onPause $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"onRestart $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }


}
