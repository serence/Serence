package org.nganga.sesame;

/**
 * Created by mansa on 10/7/15.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SerencePagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public SerencePagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Strangers strangers = new Strangers();
                return strangers;
            case 1:
                Friends friends = new Friends();
                return friends;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}