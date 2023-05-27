package com.example.imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewpager);
        List<Integer> imglist=new ArrayList<>();
        imglist.add(R.drawable.img1);
        imglist.add(R.drawable.img2);
        imglist.add(R.drawable.img3);
      myadapter md=new myadapter(imglist);
      viewPager.setAdapter(md);
    }
}