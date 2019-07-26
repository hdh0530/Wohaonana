package com.example.day_02_lxc;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTb = (TabLayout) findViewById(R.id.tb);
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Fragment> fragments = new ArrayList<>();
        strings.add("我的");
        strings.add("收藏");
        fragments.add(new BlankFragmentA());
        fragments.add(new BlankFragmentB());
        VpAdpater vpAdpater = new VpAdpater(getSupportFragmentManager(), strings, fragments);
        mVp.setAdapter(vpAdpater);
        mTb.setupWithViewPager(mVp);
        mTb.setSelectedTabIndicator(0);

    }
}
