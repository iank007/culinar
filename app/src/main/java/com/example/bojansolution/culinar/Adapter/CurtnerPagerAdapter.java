package com.example.bojansolution.culinar.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.bojansolution.culinar.CurtnerFragment1;
import com.example.bojansolution.culinar.CurtnerFragment2;
import com.example.bojansolution.culinar.CurtnerFragment3;
import com.example.bojansolution.culinar.CurtnerFragment4;

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
