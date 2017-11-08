package com.example.esha.medihome.DoctorInfo;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.example.esha.medihome.R;

public class DoctorTab extends AppCompatActivity {
    private static final String TAG = "Doctor";
    private ViewPager mViewPager;
    private SectionPageAdapter mSectionPageAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        Log.d(TAG,"onCreate:Starting.");
        mSectionPageAdapter=new SectionPageAdapter(getSupportFragmentManager());
        mViewPager=(ViewPager)findViewById(R.id.container);
        setupViewpager(mViewPager);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
    private void setupViewpager(ViewPager viewPager)
    {
        SectionPageAdapter adapter=new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new AddDoctor(),"AddDoctor");
        adapter.addFragment(new Appoinment(),"Appoinment");
        viewPager.setAdapter(adapter);

    }

}
