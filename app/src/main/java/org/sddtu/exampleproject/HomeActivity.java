package org.sddtu.exampleproject;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.sddtu.exampleproject.Adapters.FlipAdapter;
import org.sddtu.exampleproject.DataProviders.FlipViewData;

import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;
import se.emilsjolander.flipview.FlipView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FlipView flipView;
    boolean b = false;
    LinearLayout home,events,places,schedule,sponsors,about;
    String[] flipTitles = {"","CSE/IT","MAE","ECE","CIVIL",""};
    String[] buttontext = {"","CSE/IT BOOKS","MAE BOOKS","ECE BOOKS","CIVIL BOOKS",""};
    String[] flipto = {"Swipe Up for more","Swipe Up for more","Swipe Up for more","Swipe Up for more","",""};
    int[] images = {org.sddtu.exampleproject.R.drawable.eng1, org.sddtu.exampleproject.R.drawable.eng1, org.sddtu.exampleproject.R.drawable.eng1, org.sddtu.exampleproject.R.drawable.eng1, org.sddtu.exampleproject.R.drawable.eng1, org.sddtu.exampleproject.R.drawable.eng1, org.sddtu.exampleproject.R.drawable.eng1,
            org.sddtu.exampleproject.R.drawable.eng1, org.sddtu.exampleproject.R.drawable.eng1, org.sddtu.exampleproject.R.drawable.eng1, org.sddtu.exampleproject.R.drawable.eng1};
    FloatingActionButton fabplus,fabfb,fabwapp,fabtwit;
    Animation fabopen,fabclose,rotateclock,rotateanti;
    Button button;
    //ImageView imageView;
    CoordinatorLayout coordinatorLayout;
    RelativeLayout relativeLayout;
    TextView swipeup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 //       this.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        setContentView(org.sddtu.exampleproject.R.layout.activity_home);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "fonts/RobotoCondensed-Regular.ttf", true);

        coordinatorLayout = (CoordinatorLayout) findViewById(org.sddtu.exampleproject.R.id.coordinator_layout1);
        relativeLayout = (RelativeLayout)findViewById(org.sddtu.exampleproject.R.id.content_home);

//        imageView = (ImageView)findViewById(R.id.image_view1);

//        for(int i = 0;i<20;i++) {
//            new LoadAnim().execute();
//        }

        final Toolbar toolbar = (Toolbar) findViewById(org.sddtu.exampleproject.R.id.toolbar);
        setSupportActionBar(toolbar);

        button = (Button) findViewById(org.sddtu.exampleproject.R.id.regg_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,coursedetails.class);
                startActivity(intent);
            }
        });

        fabplus = (FloatingActionButton) findViewById(R.id.plusbutt);
        fabfb = (FloatingActionButton) findViewById(R.id.fbbutt);
        fabwapp = (FloatingActionButton) findViewById(R.id.wappbutt);
        fabtwit = (FloatingActionButton) findViewById(R.id.twitbutt);
        fabopen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fabclose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotateclock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        rotateanti = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
        fabplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b) {
                    fabfb.startAnimation(fabclose);
                    fabwapp.startAnimation(fabclose);
                    fabtwit.startAnimation(fabclose);
                    fabplus.startAnimation(rotateanti);
                    fabtwit.setClickable(false);
                    fabwapp.setClickable(false);
                    fabfb.setClickable(false);
                    b = false;
                } else {
                    fabfb.startAnimation(fabopen);
                    fabwapp.startAnimation(fabopen);
                    fabtwit.startAnimation(fabopen);
                    fabplus.startAnimation(rotateclock);
                    fabtwit.setClickable(true);
                    fabwapp.setClickable(true);
                    fabfb.setClickable(true);
                    b = true;
                }
            }
        });

        fabfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/ujwal.kumar.7503"));
                    startActivity(intent);
                    return;
                }
                catch (Exception e)
                {
                    // User doesn't have Facebook app installed. Try sharing through browser.
                }

                // If we failed (not native FB app installed), try share through SEND
                //String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + url;
              //  SupportUtils.doShowUri(HomeActivity.this, sharerUrl);
            }
        });

        fabtwit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uri path= Uri.parse("https://www.facebook.com/ujwal.kumar.7503");
                Intent tweetIntent = new Intent(Intent.ACTION_SEND);
                tweetIntent.putExtra(Intent.EXTRA_TEXT,
                        "Download the CourseStore app now at: https://drive.google.com/drive/u/1/folders/0B-Pt0O3_8qTDX256SDZVc0RfX00\n" +
                        "\n" +
                        "#CourseStore\n");
                tweetIntent.setType("text/plain");

                PackageManager packManager = getPackageManager();
                List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent,  PackageManager.MATCH_DEFAULT_ONLY);

                boolean resolved = false;
                for(ResolveInfo resolveInfo: resolvedInfoList){
                    if(resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")){
                        tweetIntent.setClassName(
                                resolveInfo.activityInfo.packageName,
                                resolveInfo.activityInfo.name );
                        resolved = true;
                        break;
                    }
                }
                if(resolved){
                    startActivity(tweetIntent);
                }else{
                    Toast.makeText(HomeActivity.this, "Twitter app isn't found", Toast.LENGTH_LONG).show();
                }
//                Intent shareIntent = new Intent();
//                shareIntent.setAction(Intent.ACTION_SEND);
//                shareIntent.putExtra(Intent.EXTRA_TEXT, "Testing");
//                shareIntent.putExtra(Intent.EXTRA_STREAM, path);
//                shareIntent.setType("image/*");
//                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                startActivity(Intent.createChooser(shareIntent, "Share Using"));

            }
        });

        fabwapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager pm=getPackageManager();
                try {

                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                    String text = "  \n" +
                            "Download the CourseStore app now at: https://drive.google.com/drive/u/1/folders/0B-Pt0O3_8qTDX256SDZVc0RfX00\n" +
                            "\n";

                    PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                    //Check if package exists or not. If not then code
                    //in catch block will be called
                    waIntent.setPackage("com.whatsapp");

                    waIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(waIntent, "Share with"));

                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(HomeActivity.this, "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        flipView = (FlipView) findViewById(org.sddtu.exampleproject.R.id.flip_view);
        FlipAdapter flipAdapter = new FlipAdapter(getApplicationContext(), org.sddtu.exampleproject.R.layout.custom_flip_layout);
        flipView.setAdapter(flipAdapter);

        for(int i=1;i<6;i++)
        {
            FlipViewData data = new FlipViewData(flipTitles[i],buttontext[i],flipto[i],images[i]);
            flipAdapter.add(data);
        }

        home = (LinearLayout) findViewById(org.sddtu.exampleproject.R.id.lin_home);
        events = (LinearLayout) findViewById(org.sddtu.exampleproject.R.id.lin_event);
        places = (LinearLayout) findViewById(org.sddtu.exampleproject.R.id.lin_place);
        schedule = (LinearLayout) findViewById(org.sddtu.exampleproject.R.id.lin_schedule);
       //sponsors = (LinearLayout) findViewById(R.id.lin_sponsor);
        about = (LinearLayout) findViewById(R.id.lin_about);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,EventList.class);
                startActivity(intent);
            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,EventListmae.class);
                startActivity(intent);
            }
        });

        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,EventListece.class);
                startActivity(intent);
            }
        });

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,EventListcivil.class);
                startActivity(intent);
            }
        });

       /* sponsors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,EventList.class);
                startActivity(intent);
            }
        });

      //  new LoadAnim().execute();*/

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,coursedetails.class);
                startActivity(intent);
            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                Intent intent = new Intent(HomeActivity.this,EventList.class);
//                startActivity(intent);
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(org.sddtu.exampleproject.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, org.sddtu.exampleproject.R.string.navigation_drawer_open, org.sddtu.exampleproject.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(org.sddtu.exampleproject.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(org.sddtu.exampleproject.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(org.sddtu.exampleproject.R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == org.sddtu.exampleproject.R.id.action_creator) {
            Intent intent = new Intent(HomeActivity.this,DevBy.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == org.sddtu.exampleproject.R.id.nav_camera) {
            // Handle the camera action
        } else if (id == org.sddtu.exampleproject.R.id.nav_gallery) {

        } else if (id == org.sddtu.exampleproject.R.id.nav_slideshow) {

        } else if (id == org.sddtu.exampleproject.R.id.nav_manage) {

        } else if (id == org.sddtu.exampleproject.R.id.nav_share) {

        } else if (id == org.sddtu.exampleproject.R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(org.sddtu.exampleproject.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    class LoadAnim extends AsyncTask<Void,Integer,Integer> {
//
//
//        @Override
//        protected void onProgressUpdate(Integer... values) {
//                //relativeLayout.setBackground(values[0]);
//                if (values[0]%2 == 0) {
//                    swipeup.setVisibility(View.VISIBLE);
//                } else {
//                    swipeup.setVisibility(View.INVISIBLE);
//                }
//                //imageView.setImageResource(values[0]);
//        }
//
//        @Override
//        protected Integer doInBackground(Void... params) {
//
//            for (int i = 0; i < 5; i++) {
//                publishProgress(arr[i]);
//                try {
//                    Thread.sleep(500);
//                    return i;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                //return null;
//            }
//            return 0;
//        }


//    }
}