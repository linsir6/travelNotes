package com.wenxin.dongyouji.adapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.wenxin.dongyouji.R;
import com.wenxin.dongyouji.fragment.RaidersFragment;
import com.wenxin.dongyouji.fragment.TravelNotesFragment;

/**
 * Created by linSir on 17/2/27.主界面的适配器
 */
public class HomeFragmentAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments = {new TravelNotesFragment(), new RaidersFragment()};
    private View view;
    private Context context;
    private String[] text = {"游记", "攻略"};

    public HomeFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public void setupTabLayout(final TabLayout tabLayout, final ViewPager viewPager) {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
                View view = tab.getCustomView();
                TextView tv = (TextView) view.findViewById(R.id.tv_item_custom_tab);
                tv.setTextColor(0xffffc107);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                TextView tv = (TextView) view.findViewById(R.id.tv_item_custom_tab);
                tv.setTextColor(0xffaeaeae);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    public View getTabView(int position, Context context, boolean select) {
        view = LayoutInflater.from(context).inflate(R.layout.custom_tablayout_item, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_item_custom_tab);
        tv.setText(text[position]);
        if (select) {
            tv.setTextColor(0xffffc107);
        } else {
            tv.setTextColor(0xffaeaeae);
        }
        return view;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

}
