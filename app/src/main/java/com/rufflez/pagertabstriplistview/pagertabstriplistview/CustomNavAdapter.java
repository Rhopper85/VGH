package com.rufflez.pagertabstriplistview.pagertabstriplistview;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomNavAdapter extends ArrayAdapter<String> {
    private int selectedItem;
    public CustomNavAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    public void selectedItem(int selectedItem){
        this.selectedItem = selectedItem;
        //This little bit here is called so we actually apply the change
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = super.getView(position, convertView, parent);
        //Setup a Bold and Light font
        Typeface tf1 = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Bold.ttf");
        Typeface tf2 = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Light.ttf");
        //This checks to see if something is selected, if it is, it makes it bold, if it isn't, it uses
        //the light font instead
        ((TextView)convertView).setTypeface(position == selectedItem ? tf1 : tf2);

        return convertView;
    }
}
