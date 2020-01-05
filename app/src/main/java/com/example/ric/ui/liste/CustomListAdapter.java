package com.example.ric.ui.liste;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ric.R;

public class CustomListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;

    //to store the list of countries
    private final String[] planetArray;

    public CustomListAdapter(Activity context, String[] planetArray){

        super(context, R.layout.listview_row , planetArray);
        this.context = context;
        this.planetArray = planetArray;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView planetTextField = (TextView) rowView.findViewById(R.id.planetTextID);

        //this code sets the values of the objects to values from the arrays
        planetTextField.setText(planetArray[position]);

        return rowView;

    };
}
