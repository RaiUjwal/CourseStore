package org.sddtu.exampleproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.sddtu.exampleproject.Adapters.ViewPagerAdapter;
import org.sddtu.exampleproject.Fragments.day1;
import org.sddtu.exampleproject.Fragments.day2;
import org.sddtu.exampleproject.Fragments.day3;
import org.sddtu.exampleproject.Fragments.day4;
import org.sddtu.exampleproject.Fragments.day5;
import org.sddtu.exampleproject.Fragments.day6;
import org.sddtu.exampleproject.Fragments.day7;
import org.sddtu.exampleproject.Fragments.day8;

import me.anwarshahriar.calligrapher.Calligrapher;

public class EventList extends AppCompatActivity {


    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   this.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        setContentView(org.sddtu.exampleproject.R.layout.activity_event_list);

        getSupportActionBar().setTitle("CS/IT BOOKS");

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "fonts/OpenSans-Regular.ttf", true);

        viewPager = (ViewPager) findViewById(org.sddtu.exampleproject.R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragments(new day1());
        viewPagerAdapter.AddFragments(new day2());
        viewPagerAdapter.AddFragments(new day3());
        viewPagerAdapter.AddFragments(new day4());
        viewPagerAdapter.AddFragments(new day5());
        viewPagerAdapter.AddFragments(new day6());
        viewPagerAdapter.AddFragments(new day7());
        viewPagerAdapter.AddFragments(new day8());
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(org.sddtu.exampleproject.R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}