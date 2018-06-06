package com.college.lasalle.examexcercise_p;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add the code for SwipeAdapter
        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        if (pager != null){

            pager.setAdapter(new SwipeAdapter(getSupportFragmentManager()));
        }
    }
}
