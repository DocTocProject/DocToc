package com.tp1.DocHome;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class TutoActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuto);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        FragmentManager fm = getSupportFragmentManager();

        ArrayList<Fragment> pagesFragmentList = new ArrayList<>();
        pagesFragmentList.add(new TutoSlide0Fragment());
        pagesFragmentList.add(new TutoSlide1Fragment());
        pagesFragmentList.add(new TutoSlide2Fragment());
        pagesFragmentList.add(new TutoSlide3Fragment());

        pager.setAdapter(new TutorialAdapter(fm, pagesFragmentList));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("currentSlide", position);
        editor.commit();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}

