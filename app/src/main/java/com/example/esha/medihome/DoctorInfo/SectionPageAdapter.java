package com.example.esha.medihome.DoctorInfo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatema on 11/8/17.
 */

public class SectionPageAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mfragmentList=new ArrayList<>();
    private final List<String> mfragmentTitleList=new ArrayList<>();


    public SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }
    public CharSequence getPageTitle(int position)
    {
        return mfragmentTitleList.get(position);
    }
    public void addFragment(Fragment fragment,String title)
    {
        mfragmentList.add(fragment);
        mfragmentTitleList.add(title);
    }
}
