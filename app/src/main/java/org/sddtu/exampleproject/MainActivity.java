package org.sddtu.exampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    //VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_splash);
       // getSupportActionBar().setTitle("CourseStore");



        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    /**/
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        };
        th.start();
       // startActivity(new Intent(MainActivity.this,HomeActivity.class));

    }
}
