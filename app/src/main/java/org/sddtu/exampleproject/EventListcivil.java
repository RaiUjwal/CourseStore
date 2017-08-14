package org.sddtu.exampleproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.sddtu.exampleproject.Adapters.ViewPagerAdapter;
import org.sddtu.exampleproject.Fragments.ceday1;
import org.sddtu.exampleproject.Fragments.ceday2;
import org.sddtu.exampleproject.Fragments.ceday3;
import org.sddtu.exampleproject.Fragments.ceday4;
import org.sddtu.exampleproject.Fragments.ceday5;
import org.sddtu.exampleproject.Fragments.ceday6;
import org.sddtu.exampleproject.Fragments.ceday7;
import org.sddtu.exampleproject.Fragments.ceday8;

import me.anwarshahriar.calligrapher.Calligrapher;

public class EventListcivil extends AppCompatActivity {


    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   this.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        setContentView(org.sddtu.exampleproject.R.layout.activity_event_list);

        getSupportActionBar().setTitle("CIVIL BOOKS");

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "fonts/OpenSans-Regular.ttf", true);

        viewPager = (ViewPager) findViewById(org.sddtu.exampleproject.R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragments(new ceday1());
        viewPagerAdapter.AddFragments(new ceday2());
        viewPagerAdapter.AddFragments(new ceday3());
        viewPagerAdapter.AddFragments(new ceday4());
        viewPagerAdapter.AddFragments(new ceday5());
        viewPagerAdapter.AddFragments(new ceday6());
        viewPagerAdapter.AddFragments(new ceday7());
        viewPagerAdapter.AddFragments(new ceday8());
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(org.sddtu.exampleproject.R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}