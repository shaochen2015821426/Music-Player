package com.example.myapplicationexercise;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.myapplicationexercise.adapter.FragmentDemoAdapter;
import com.example.myapplicationexercise.fragment.FragmentA;
import com.example.myapplicationexercise.fragment.FragmentB;

import java.util.ArrayList;
import java.util.List;

public class FragmentDemoActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private  List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        viewPager = findViewById(R.id.fragment_vp);

        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();

        fragmentList.add(fragmentA);
        fragmentList.add(fragmentB);

        FragmentDemoAdapter adapter = new FragmentDemoAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);


    }
}
