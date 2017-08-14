package org.sddtu.exampleproject.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.sddtu.exampleproject.DataProviders.FlipViewData;
import org.sddtu.exampleproject.EventList;
import org.sddtu.exampleproject.EventListcivil;
import org.sddtu.exampleproject.EventListece;
import org.sddtu.exampleproject.EventListmae;
import org.sddtu.exampleproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohitkumar on 07/01/17.
 */

public class FlipAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public FlipAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class Data {
        TextView title;
        ImageView background;
        TextView exptext;
        TextView swipe;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row = convertView;
        Data d;
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.custom_flip_layout,parent,false);
            d = new Data();
            d.title = (TextView) row.findViewById(R.id.flip_text);
            d.background = (ImageView)row.findViewById(R.id.background_work);
            d.exptext = (TextView) row.findViewById(R.id.exp_button);
            d.swipe = (TextView)row.findViewById(R.id.swipe_text);
            row.setTag(d);
        }
        else {
            d = (Data) row.getTag();
        }

        FlipViewData flipViewData = (FlipViewData) this.getItem(position);
        d.title.setText(flipViewData.getPlace());
        d.background.setImageResource(flipViewData.getImagesrc());
        d.exptext.setText(flipViewData.getButtext());

        d.swipe.setText(flipViewData.getSwipetext());

        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"fonts/RobotoCondensed-Regular.ttf");

        Typeface tf1 = Typeface.createFromAsset(getContext().getAssets(),"fonts/OpenSans-Light.ttf");


        d.title.setTypeface(tf1);
        d.exptext.setTypeface(tf);
        d.swipe.setTypeface(tf1);

        row.findViewById(R.id.exp_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v.findViewById(R.id.exp_button);
                String s = textView.getText().toString();
                switch (s) {
                    case "C" : {
                      //  Toast.makeText(getContext(),"EngiData here",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfDE9DQu8k-7vUop34rlmCDzLWTV5Xiyb2fmGZpfbPCr3YKKQ/viewform"));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getContext().startActivity(intent);
                        break;
                    }
                    case "CSE/IT BOOKS":{
                        //Toast.makeText(getContext(),"Events here",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getContext(),EventList.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getContext().startActivity(intent);
                        break;
                    }
                    case "MAE BOOKS" : {
                        //Toast.makeText(getContext(),"Places here",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getContext(),EventListmae.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getContext().startActivity(intent);
                        break;
                    }
                    case "ECE BOOKS" : {
                      //  Toast.makeText(getContext(),"Schedule here",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getContext(),EventListece.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getContext().startActivity(intent);
                        break;
                    }
                    case "CIVIL BOOKS" : {
                       // Toast.makeText(getContext(),"About us here",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getContext(), EventListcivil.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getContext().startActivity(intent);
                        break;
                    }
                    case "MORE SPONSORS" : {
                        Intent intent = new Intent(getContext(), EventList.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getContext().startActivity(intent);
                       // Toast.makeText(getContext(),"Sponsors here",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "CLICK HERE" : {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfDE9DQu8k-7vUop34rlmCDzLWTV5Xiyb2fmGZpfbPCr3YKKQ/viewform"));
                        getContext().startActivity(intent);
                    }
                }
            }
        });

        return row;
    }
}
