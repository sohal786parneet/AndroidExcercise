package com.college.lasalle.examexcercise_p;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SwipeAdapter extends FragmentStatePagerAdapter {

    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new BlueFragment();
        }
           return new GreenFragment();
    }


    @Override
    public int getCount() {
        return 2;
    }
}
