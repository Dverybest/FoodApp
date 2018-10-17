package com.dverybest.fun;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private Button mNext,mSkip,mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        TabLayout tabLayout =  findViewById(R.id.tabDots);
        mNext = findViewById(R.id.btnNext);
        mSkip = findViewById(R.id.btnSkip);
        mStart = findViewById(R.id.btnStart);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager =  findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager, true);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                // changing the next button text 'NEXT' / 'GOT IT'
                if (position == 2) {
                    // last page. make button text to GOT IT
                    mNext.setVisibility(View.GONE);
                    mSkip.setVisibility(View.GONE);
                    mStart.setVisibility(View.VISIBLE);
                } else {
                    mNext.setVisibility(View.VISIBLE);
                    mSkip.setVisibility(View.VISIBLE);
                    mStart.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = mViewPager.getCurrentItem() + 1;
                mViewPager.setCurrentItem(position);
            }
        });

        mSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(WelcomeActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("done", "skip");
                editor.apply();
                Intent i = new Intent( WelcomeActivity.this,DashActivity.class);
                startActivity(i);

                finish();
            }
        });
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(WelcomeActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("done", "skip");
                editor.apply();
                Intent i = new Intent( WelcomeActivity.this,DashActivity.class);
                startActivity(i);
                finish();

            }

        });
    }
    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView =  rootView.findViewById(R.id.t1);
            TextView textView2 =  rootView.findViewById(R.id.quote);
            if (getArguments().getInt(ARG_SECTION_NUMBER) ==1){
                textView.setText("DISCOVER THE BEST OF AFRICAN DISHES");
                textView2.setText("View Our Fantastically Delious Meal Menu");

            }else if (getArguments().getInt(ARG_SECTION_NUMBER) ==2){

                textView.setText("ORDER AND MAKE RESERVATIONS ONLINE");
                textView2.setText("Get Your Food Delivered in Mintues If You Live Within 6 Block Radius");

            }else if (getArguments().getInt(ARG_SECTION_NUMBER) ==3){

                textView.setText("HUNGRY?");
                textView2.setText("Start Your Orders Right Away");

            }

            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}
