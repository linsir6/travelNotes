package com.wenxin.dongyouji.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.wenxin.dongyouji.R;
import com.wenxin.dongyouji.adapter.HomeFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private HomeFragmentAdapter mAdapter;    //适配器
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        user = (ImageView) findViewById(R.id.user);
        initviews();


    }

    private void initviews() {
        /**
         * HomeActivity里面的元素,绑定id
         */
        //draw_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mAdapter = new HomeFragmentAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(mAdapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(0xffffc107);
        mAdapter.setupTabLayout(tabLayout, viewPager);


        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);

            if (tab != null) {
                if (i == 0) {
                    tab.setCustomView(mAdapter.getTabView(i, this, true));
                } else {
                    tab.setCustomView(mAdapter.getTabView(i, this, false));
                }
            }
        }

        user.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MeActivity.class);
                startActivity(intent);
            }
        });
    }

}
