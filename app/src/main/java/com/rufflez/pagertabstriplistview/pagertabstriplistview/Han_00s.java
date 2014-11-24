package com.rufflez.pagertabstriplistview.pagertabstriplistview;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Han_00s extends ListFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        String[] strings = getResources().getStringArray(R.array.han_00);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strings));
        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Toast.makeText(getActivity(), "You selected " + position, Toast.LENGTH_LONG).show();
    }
}
