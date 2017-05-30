package com.svs.myprojects.tabswipeinsidetabhost;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by snehalsutar on 1/20/16.
 */
public class Tab1Fragment extends Fragment {

    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    Context mFragContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFragContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.tab1_view, container, false);
        mCustomPagerAdapter = new CustomPagerAdapter(getFragmentManager());

        mViewPager = (ViewPager) V.findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

        WebView webView=(WebView)V.findViewById(R.id.webView);
        webView.loadUrl("www.google.com");

        return V;
    }


    class CustomPagerAdapter extends FragmentStatePagerAdapter {

//        Context mContext;

        public CustomPagerAdapter(FragmentManager fm) {
            super(fm);
//            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {

            // Create fragment object
            Fragment fragment = new DemoFragment();

            // Attach some data to the fragment
            // that we'll use to populate our fragment layouts
            Bundle args = new Bundle();
            args.putInt("page_position", position + 1);

            // Set the arguments on the fragment
            // that will be fetched in the
            // DemoFragment@onCreateView
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title="";
            switch (position){
                case 0:
                    title = "PAG1";
                    break;
                case 1:
                    title = "PAG2";
                    break;
                case 2:
                    title = "PAG3";
                    break;
                case 3:
                    title = "PAG4";
                    break;

            }
            return title; //"Page " + (position + 1);
        }
    }

}