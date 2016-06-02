package com.penguin.padang.pasir.sqlitesharedpreferences.views.imp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.penguin.padang.pasir.sqlitesharedpreferences.R;
import com.penguin.padang.pasir.sqlitesharedpreferences.infrastructure.PersonAdapter;

import java.util.ArrayList;

public class ListViewAcivity extends AppCompatActivity {

    private ArrayList<String> listPerson = new ArrayList<>();
    private String[] namePerson = {"Asrul", "Sani", "Ariesandy"};

    private ListView listView;
    private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_acivity);
        listView = (ListView) findViewById(R.id.person_list);



        for (int i = 0; i < namePerson.length; i++) {
            listPerson.add(namePerson[i]);
        }

        personAdapter = new PersonAdapter(ListViewAcivity.this,android.R.layout.simple_list_item_1,listPerson);

        listView.setAdapter(personAdapter);

    }
}
