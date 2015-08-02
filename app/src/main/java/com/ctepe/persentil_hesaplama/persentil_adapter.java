package com.ctepe.persentil_hesaplama;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ctepe on 2.8.2015.
 */
public class persentil_adapter extends FragmentStatePagerAdapter {
    public persentil_adapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment fragment;

    @Override
    public Fragment getItem(int position) {



        switch (position){
            case 0:{
                fragment = new persentil_fragment();
                return fragment;
            }
            case 1:{
                fragment = new persentil_fragment();
                return fragment;
            }
        }
        return null;

    }

    @Override
    public int getCount() {
        return 2;
    }
}
