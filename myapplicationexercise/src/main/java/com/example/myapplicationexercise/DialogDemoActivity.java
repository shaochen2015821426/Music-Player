package com.example.myapplicationexercise;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogDemoActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo);

        button = findViewById(R.id.dialog_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final View view = LayoutInflater.from(DialogDemoActivity.this).inflate(R.layout.dialog_item_layout,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogDemoActivity.this);
                builder.setTitle("登录");
                builder.setView(view);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText nameEt = view.findViewById(R.id.dialog_item_name_et);
                        Toast.makeText(DialogDemoActivity.this,nameEt.getText().toString(),Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }
        });
    }
}
