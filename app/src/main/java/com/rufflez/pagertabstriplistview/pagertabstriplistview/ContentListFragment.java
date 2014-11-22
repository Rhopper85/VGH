package com.rufflez.pagertabstriplistview.pagertabstriplistview;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ContentListFragment extends ListFragment {
    //This is just a plain list fragment that shows your items...
    // You'll want to change the data expressed
    private static final String ARG_POSITION = "position";

    private int position;

    public static ContentListFragment newInstance(int position){
        ContentListFragment fragment = new ContentListFragment();
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
                "Magnavox Odyssey",
                "Magnavox Odyssey 100",
                "Magnavox Odyssey 200",
                "Tele-Games Pong",
                "Atari Pong",
                "Fairchild Channel-F",
                "Magnavox Odyssey 300",
                "Magnavox Odyssey 400",
                "Magnavox Odyssey 500",
                "Nintendo Color TV Game",
                "Magnavox Odyssey 2000",
                "Magnavox Odyssey 3000",
                "Magnavox Odyssey 4000",
                "Magnavox Odyssey 2",
                "Mattel Intellivision",
        };
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items));
        return v;
    }

}
