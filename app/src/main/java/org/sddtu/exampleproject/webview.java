package org.sddtu.exampleproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

public class webview extends AppCompatActivity {
   // private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        String text = getIntent().getStringExtra("course").toString();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

  if(text.equals("1")){
      getSupportActionBar().setTitle("CSE/IT COURSE DETAILS");
        WebView webView = (WebView) findViewById(R.id.web_view1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.amity.edu/admission/course_structure/A23052.html");
        //setContentView(webView);
    }
    else if(text.equals("2")){getSupportActionBar().setTitle("MAE COURSE DETAILS");
      WebView webView = (WebView) findViewById(R.id.web_view1);
      webView.getSettings().setJavaScriptEnabled(true);
      webView.loadUrl("http://www.amity.edu/admission/course_structure/A23054.html");
      //setContentView(webView);
  }
  else if(text.equals("3")){getSupportActionBar().setTitle("ECE COURSE DETAILS");
      WebView webView = (WebView) findViewById(R.id.web_view1);
      webView.getSettings().setJavaScriptEnabled(true);
      webView.loadUrl("http://www.amity.edu/admission/course_structure/A23246.html");
      //setContentView(webView);
  }
  else if(text.equals("4")){getSupportActionBar().setTitle("CIVIL COURSE DETAILS");
      WebView webView = (WebView) findViewById(R.id.web_view1);
      webView.getSettings().setJavaScriptEnabled(true);
      webView.loadUrl("http://www.amity.edu/admission/course_structure/A23158.html");
      //setContentView(webView);
  }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
