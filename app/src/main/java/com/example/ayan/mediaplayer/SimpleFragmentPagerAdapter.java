package com.example.ayan.mediaplayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int i) {
       if (i == 0){
           return new IdFragment();
       }

       else if (i == 1){
           return new LayoutFragment();
       }

       else
           return new SettingsFragment();
    }
}
