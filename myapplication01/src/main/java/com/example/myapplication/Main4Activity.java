package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener{
    private Button intoBtn;
    private Button dateBtn;
    private Button timeBtn;
    private  Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        intoBtn = findViewById(R.id.main4_into_Btn);
        dateBtn = findViewById(R.id.main4_date_Btn);
        timeBtn = findViewById(R.id.main4_time_Btn);
        timeBtn.setOnClickListener(this);
        intoBtn.setOnClickListener(this);
        dateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main4_into_Btn:
                ProgressDialog progressDialog = new ProgressDialog(Main4Activity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setTitle("温情提示");
                progressDialog.setMessage("这是一个进度条对话框");
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(true);
                progressDialog.setButton(-1, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                progressDialog.show();
                break;
            case R.id.main4_date_Btn:
                calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(Main4Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        Toast.makeText(Main4Activity.this,year+"-"+(month+1)+"-"+dayOfMonth,Toast.LENGTH_SHORT).show();

                    }
                },year,month,day);
                datePickerDialog.show();
                break;
            case R.id.main4_time_Btn:
                int hour = calendar.get(Calendar.HOUR);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(Main4Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(Main4Activity.this,"所选择的时间是："+hourOfDay+":"+minute,Toast.LENGTH_SHORT).show();

                    }
                },hour,minute,true);
                timePickerDialog.show();
                break;
        }

    }
}
