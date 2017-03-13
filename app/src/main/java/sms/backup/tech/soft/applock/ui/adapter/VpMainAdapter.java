package sms.backup.tech.soft.applock.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dee on 11/03/2017.
 */

public class VpMainAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public VpMainAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
    }

    public void addFragment(Fragment fragment){
        fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (0 == position){
            return "All App";
        } else if (1 == position){
            return "System App";
        } else if (2 == position){
            return "User App";
        } else {
            return "Setting";
        }

    }
}
