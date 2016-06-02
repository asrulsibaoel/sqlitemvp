package com.penguin.padang.pasir.sqlitesharedpreferences.infrastructure;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by jowy on 6/2/16.
 */
public class PersonAdapter extends ArrayAdapter<String> {

    public PersonAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }
}
