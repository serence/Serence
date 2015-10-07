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
                Strangers tab1 = new Strangers();
                return tab1;
            case 1:
                Friends tab2 = new Friends();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}