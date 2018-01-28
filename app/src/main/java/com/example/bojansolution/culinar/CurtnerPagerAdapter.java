package com.example.bojansolution.culinar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by bojan solution on 28/01/2018.
 */

public class CurtnerPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public CurtnerPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CurtnerFragment1();
            case 1:
                return new CurtnerFragment2();
            case 2:
                return new CurtnerFragment3();
            case 3:
                return new CurtnerFragment4();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
