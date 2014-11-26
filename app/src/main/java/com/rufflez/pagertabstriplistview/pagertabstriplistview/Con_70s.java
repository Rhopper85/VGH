package com.rufflez.pagertabstriplistview.pagertabstriplistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Con_70s extends ListFragment {
    //This is just a plain list fragment that shows your items...
    // You'll want to change the data expressed

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        String[] items = getResources().getStringArray(R.array.con_70);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items));
        return v;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Class c = null;
        switch (position) {
            case 0:
                c = Con_Odyssey.class;
                break;
            case 1:
                c = Con_Odyssey_100.class;
                break;
        }
        Intent i = new Intent(v.getContext(), c);
        startActivity(i);
        //Toast.makeText(getActivity(), "You Selected " + position, Toast.LENGTH_LONG).show();
    }
}
