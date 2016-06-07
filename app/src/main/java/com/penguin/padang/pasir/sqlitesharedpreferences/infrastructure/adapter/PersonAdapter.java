package com.penguin.padang.pasir.sqlitesharedpreferences.infrastructure.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.penguin.padang.pasir.sqlitesharedpreferences.R;
import com.penguin.padang.pasir.sqlitesharedpreferences.models.Person;

import java.util.List;

/**
 * Created by jowy on 6/2/16.
 */
public class PersonAdapter extends ArrayAdapter<Person> {

    Context context;
    int resourceId;
    List<Person> textList;

    public PersonAdapter(Context context, int resource, List<Person> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceId = resource;
        this.textList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = convertView;

        if (root == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            root = inflater.inflate(resourceId, parent, false);
            TextView textName = (TextView) root.findViewById(R.id.text_name);
            TextView textAddress = (TextView) root.findViewById(R.id.text_address);
            textName.setText(textList.get(position).getName());
            textAddress.setText(textList.get(position).getAddress());

        }


        return root;
    }
}
