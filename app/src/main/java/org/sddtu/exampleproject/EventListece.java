package org.sddtu.exampleproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.sddtu.exampleproject.Adapters.ViewPagerAdapter;
import org.sddtu.exampleproject.Fragments.eceday1;
import org.sddtu.exampleproject.Fragments.eceday2;
import org.sddtu.exampleproject.Fragments.eceday3;
import org.sddtu.exampleproject.Fragments.eceday4;
import org.sddtu.exampleproject.Fragments.eceday5;
import org.sddtu.exampleproject.Fragments.eceday6;
import org.sddtu.exampleproject.Fragments.eceday7;
import org.sddtu.exampleproject.Fragments.eceday8;

import me.anwarshahriar.calligrapher.Calligrapher;

public class EventListece extends AppCompatActivity {


    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   this.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        setContentView(org.sddtu.exampleproject.R.layout.activity_event_list);

        getSupportActionBar().setTitle("ECE BOOKS");

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "fonts/OpenSans-Regular.ttf", true);

        viewPager = (ViewPager) findViewById(org.sddtu.exampleproject.R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragments(new eceday1());
        viewPagerAdapter.AddFragments(new eceday2());
        viewPagerAdapter.AddFragments(new eceday3());
        viewPagerAdapter.AddFragments(new eceday4());
        viewPagerAdapter.AddFragments(new eceday5());
        viewPagerAdapter.AddFragments(new eceday6());
        viewPagerAdapter.AddFragments(new eceday7());
        viewPagerAdapter.AddFragments(new eceday8());
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(org.sddtu.exampleproject.R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}