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
 * Use the {@link ceday7#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ceday7 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    ListView listView;
    String[] events = {"Construction Technology & Project Management"};
    String[] venue = {"Garold D. Oberlender"};
    String[] time = {"8.97Mb"};

    public ceday7() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment day7.
     */
    // TODO: Rename and change types and number of parameters
    public static ceday7 newInstance(String param1, String param2) {
        ceday7 fragment = new ceday7();
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
        View v =  inflater.inflate(R.layout.fragment_day7, container, false);

        // Inflate the layout for this fragment
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),"fonts/OpenSans-Light.ttf");

        TextView textView = (TextView) v.findViewById(R.id.day_7);
        textView.setTypeface(tf);
        listView = (ListView) v.findViewById(R.id.list_view7);
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
               //view = parent.getChildAt(position);
               // Intent Browserintent=new Intent();
                TextView textView1 = (TextView) view.findViewById(R.id.list_name);
                String a = textView1.getText().toString();
                Log.d("A",a);
                //Intent intent = new Intent(getActivity(), MasterEventActivity.class);
                //Intent intent1 = new Intent(getActivity(),Doremipa.class);
                switch (position){
                    case 0:
                        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://drive.google.com/open?id=0B-Pt0O3_8qTDWkl1dXROOGlOMTA"));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getContext().startActivity(intent);
                        break;
                   /* case 1:
                        Intent Browserintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0B-Pt0O3_8qTDWkl1dXROOGlOMTA"));
                        startActivity(Browserintent);
                        break;
                    case 2:
                        Intent Browserintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0B-Pt0O3_8qTDWkl1dXROOGlOMTA"));
                        startActivity(Browserintent);
                        break;
                    case 3:
                        Intent Browserintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0B-Pt0O3_8qTDWkl1dXROOGlOMTA"));
                        startActivity(Browserintent);
                        break;
                     case 4:
                        Intent Browserintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0B-Pt0O3_8qTDWkl1dXROOGlOMTA"));
                        startActivity(Browserintent);
                        break;
*/
                }
            }
        });

        return v;

    }

}
