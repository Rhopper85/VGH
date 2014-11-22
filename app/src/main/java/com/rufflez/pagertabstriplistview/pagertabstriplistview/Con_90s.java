package com.rufflez.pagertabstriplistview.pagertabstriplistview;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class Con_90s extends ListFragment {
    //This is just a plain list fragment that shows your items...
    // You'll want to change the data expressed
    private static final String ARG_POSITION = "position";

    private int position;
    public static final String TAG = Con_90s.class.getSimpleName();

    public static Con_90s newInstance(int position){
        Con_90s fragment = new Con_90s();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        String[] items = new String[]{
                "SNK NeoGeo",
                "Super Nintendo Entertainment System",
                "Atari Jaguar",
                "Sega Saturn",
                "Nintendo Virtualboy",
                "Sony Playstation",
                "Nintendo 64",
                "Sega Dreamcast",
        };
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items));
        return v;
    }

}
