package org.sddtu.exampleproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.sddtu.exampleproject.Adapters.ViewPagerAdapter;
import org.sddtu.exampleproject.Fragments.maeday1;
import org.sddtu.exampleproject.Fragments.maeday2;
import org.sddtu.exampleproject.Fragments.maeday3;
import org.sddtu.exampleproject.Fragments.maeday4;
import org.sddtu.exampleproject.Fragments.maeday5;
import org.sddtu.exampleproject.Fragments.maeday6;
import org.sddtu.exampleproject.Fragments.maeday7;
import org.sddtu.exampleproject.Fragments.maeday8;

import me.anwarshahriar.calligrapher.Calligrapher;

public class EventListmae extends AppCompatActivity {


    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   this.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        setContentView(org.sddtu.exampleproject.R.layout.activity_event_list);

        getSupportActionBar().setTitle("MAE BOOKS");

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "fonts/OpenSans-Regular.ttf", true);

        viewPager = (ViewPager) findViewById(org.sddtu.exampleproject.R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragments(new maeday1());
        viewPagerAdapter.AddFragments(new maeday2());
        viewPagerAdapter.AddFragments(new maeday3());
        viewPagerAdapter.AddFragments(new maeday4());
        viewPagerAdapter.AddFragments(new maeday5());
        viewPagerAdapter.AddFragments(new maeday6());
        viewPagerAdapter.AddFragments(new maeday7());
        viewPagerAdapter.AddFragments(new maeday8());
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(org.sddtu.exampleproject.R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}