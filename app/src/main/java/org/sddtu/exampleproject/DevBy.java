package org.sddtu.exampleproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.anwarshahriar.calligrapher.Calligrapher;

public class DevBy extends AppCompatActivity {


    FloatingActionButton git1,git2,git3,link1,link2,link3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(org.sddtu.exampleproject.R.layout.activity_dev_by);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "fonts/OpenSans-Regular.ttf", true);


        git1 = (FloatingActionButton) findViewById(org.sddtu.exampleproject.R.id.mohit_git);
      //  git2 = (FloatingActionButton) findViewById(R.id.krishna_git);
       // git3 = (FloatingActionButton) findViewById(R.id.ashish_git);

        link1 = (FloatingActionButton) findViewById(org.sddtu.exampleproject.R.id.mohit_link);
        //link2 = (FloatingActionButton) findViewById(R.id.krishna_link);
        //link3 = (FloatingActionButton) findViewById(R.id.ashish_link);

        git1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/RaiUjwal");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        /*git2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/krishnarai30");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        git3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/ashish05182001");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });



        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://in.linkedin.com/in/krishnarai30");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/ashish05182001");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });*/
        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/ujwal-rai-abb617142/");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }
}
