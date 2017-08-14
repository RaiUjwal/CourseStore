package org.sddtu.exampleproject.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.sddtu.exampleproject.DataProviders.ListViewData;
import org.sddtu.exampleproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohitkumar on 15/01/17.
 */

public class ListViewAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public ListViewAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class Data {
        TextView eventname;
        TextView venue;
        TextView time;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        view = convertView;
        Data d;
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.custom_listview,parent,false);
            d = new Data();
            d.eventname = (TextView)view.findViewById(R.id.list_name);
            d.venue = (TextView)view.findViewById(R.id.venue);
            d.time = (TextView)view.findViewById(R.id.time1);
            view.setTag(d);
        }
        else  {
            d = (Data)view.getTag();
        }
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"fonts/OpenSans-Light.ttf");
        Typeface tff = Typeface.createFromAsset(getContext().getAssets(),"fonts/OpenSans-Regular.ttf");

        d.eventname.setTypeface(tf);
        d.time.setTypeface(tff);
        d.venue.setTypeface(tff);

        ListViewData listViewData = (ListViewData) this.getItem(position);
        d.eventname.setText(listViewData.getEvent());
        d.venue.setText(listViewData.getVenue());
        d.time.setText(listViewData.getTime());
        return view;
    }
}
