package com.rufflez.pagertabstriplistview.pagertabstriplistview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

public class ConsolePagerTabStripFragment extends Fragment {

    public static final String TAG = ConsolePagerTabStripFragment.class.getSimpleName();

    public static ConsolePagerTabStripFragment newInstance() {
        return new ConsolePagerTabStripFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //This requires the PagerSlidingTabStrip library.
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        //Setting the bottom bar of the tabstrip to red
        tabs.setIndicatorColor(getResources().getColor(R.color.colorPrimary));
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        private final String[] TITLES = {"1970's", "1980's", "1990's",
                "2000's", "2010's"};

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        //For each page, we are creating a list fragment that doesn't have any special data in it
        // You'll want to specify and special fragments here based on position with a switch clause.
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Con_70s();
                case 1:
                    return new Con_80s();
                case 2:
                    return new Con_90s();
                case 3:
                    return new Con_00s();
                case 4:
                    return new Con_10s();
                default:
                    return null;
            }
        }
    }
}

