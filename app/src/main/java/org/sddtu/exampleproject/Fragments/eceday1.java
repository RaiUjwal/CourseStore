package org.sddtu.exampleproject.Fragments;


import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.sddtu.exampleproject.Adapters.ListViewAdapter;
import org.sddtu.exampleproject.DataProviders.ListViewData;
import org.sddtu.exampleproject.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link eceday1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class eceday1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    int i=1;
    ListView listView;
    String[] events = {"Let us c","Applied Physics I","Applied Mathematics","Engineering Mechanics"};
    String[] venue = {"Yashwant Kantekar","Arthur Bieser","Erwin Kreyiz","S.S Bhavikatti"};
    String[] time = {"7Mb","31Mb","21.6Mb","3Mb"};


    public eceday1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment day1.
     */
    // TODO: Rename and change types and number of parameters
    public static eceday1 newInstance(String param1, String param2) {
        eceday1 fragment = new eceday1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_day1, container, false);

        // Inflate the layout for this fragment
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),"fonts/OpenSans-Light.ttf");

        TextView textView = (TextView) v.findViewById(R.id.day_1);
        textView.setTypeface(tf);
        listView = (ListView) v.findViewById(R.id.list_view);
        ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), R.layout.custom_listview);
        listView.setAdapter(listViewAdapter);
        for(int i=0;i<events.length;i++)
        {
            ListViewData data = new ListViewData(events[i],venue[i],time[i]);
            listViewAdapter.add(data);
        }



       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // view = parent.getChildAt(position);
                TextView textView1 = (TextView) view.findViewById(R.id.list_name);
                String a = textView1.getText().toString();
                Log.d("A",a);
                 Intent intent;
                //Intent intent = new Intent(getActivity(), MasterEventActivity.class);
                //Intent intent1 = new Intent(getActivity(),Doremipa.class);
                switch (position){
                    case 0:
                        intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0B-Pt0O3_8qTDcDlLa1A3RWpvSXM"));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getContext().startActivity(intent);
                        break;
                    case 1:
                         intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0B-Pt0O3_8qTDc0VPb3FnYUlOOTQ"));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        break;
                    case 2:
                        intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0B-Pt0O3_8qTDR0FVeWMwY0k2UU0"));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        break;
                    case 3:
                        intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0B7raaoEF40D7T1FvelR1eWFZS2s"));

                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        break;
                }
            }
        });

        return v;

    }

}