package com.sple.slidingpanellayout_example;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class PagerAdapter extends FragmentStatePagerAdapter {

    protected PageFragment pageFragment;

    protected int pagerNumber;

    public PagerAdapter(FragmentManager fm) {
        super(fm);

        pageFragment = new PageFragment();
    }


    public void setData(int _pagerNumber) {
        pagerNumber = _pagerNumber;

        //Log.v("111", pagerNumber + "");

        notifyDataSetChanged();
    }

    @Override
    public Parcelable saveState()
    {
        return null;
    }

    @Override
    public Fragment getItem(int i) {
        pageFragment = new PageFragment();

        pageFragment.setData("Current pager number = " + pagerNumber + "\nPage number = " + i);

        return  pageFragment;
    }

    @Override
    public int getCount() {
        return 20;
    }
}
