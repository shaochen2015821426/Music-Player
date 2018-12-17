package com.example.myapplicationexercise;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplicationexercise.adapter.StudentAdapter;
import com.example.myapplicationexercise.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView ;
    private List<Student> studentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Student stud1 = new Student("张三",29,"合肥");
        Student stud2 = new Student("李四",28,"无锡");
        Student stud3 = new Student("Amily",27,"纽约");

        studentList.add(stud1);
        studentList.add(stud2);
        studentList.add(stud3);
        listView = findViewById(R.id.main_list);
        StudentAdapter studentAdapter = new StudentAdapter(MainActivity.this,studentList);
        listView.setAdapter(studentAdapter);
    }
}
