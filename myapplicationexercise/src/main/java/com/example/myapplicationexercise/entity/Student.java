package com.example.myapplicationexercise.entity;

/**
 * Created by shaoyangyang on 2017/12/27.
 */

public class Student {

    private  String name;
    private int age;
    private  String home;

    public Student(String name,int age, String home){
        this.name = name;
        this.age = age;
        this.home = home;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
