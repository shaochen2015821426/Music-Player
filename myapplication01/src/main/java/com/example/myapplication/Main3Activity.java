package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    private TextView sureBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        sureBtn = findViewById(R.id.main3_sure_Btn);
        sureBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main3_sure_Btn:
                final View view = LayoutInflater.from(this).inflate(R.layout.dialog2_layout, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("登录");
                builder.setView(view);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText nameeditText = view.findViewById(R.id.dialog2_name_et);
                        String name = nameeditText.getText().toString();
                        Toast.makeText(Main3Activity.this, name, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
        }

    }
}
