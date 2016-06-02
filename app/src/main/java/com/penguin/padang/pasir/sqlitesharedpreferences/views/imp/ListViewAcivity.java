package com.penguin.padang.pasir.sqlitesharedpreferences.views.imp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.penguin.padang.pasir.sqlitesharedpreferences.R;
import com.penguin.padang.pasir.sqlitesharedpreferences.infrastructure.PersonAdapter;
import com.penguin.padang.pasir.sqlitesharedpreferences.models.Person;
import com.penguin.padang.pasir.sqlitesharedpreferences.presenters.PersonListImp;
import com.penguin.padang.pasir.sqlitesharedpreferences.presenters.PersonListInterface;
import com.penguin.padang.pasir.sqlitesharedpreferences.views.interfaces.ListViewActivityInterface;

import java.util.ArrayList;

public class ListViewAcivity extends AppCompatActivity implements ListViewActivityInterface{

    private PersonListInterface personListInterface;

    private ArrayList<Person> listPerson = new ArrayList<>();
    private String[] namePerson;

    private ListView listView;
    private PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_acivity);
        listView = (ListView) findViewById(R.id.person_list);

        personListInterface = new PersonListImp(ListViewAcivity.this, listView);
        personListInterface.showAllPerson();

//
//        for (int i = 0; i < namePerson.length; i++) {
//            listPerson.add(namePerson[i]);
//        }
//
//        personAdapter = new PersonAdapter(ListViewAcivity.this,android.R.layout.simple_list_item_1,listPerson);
//
//        listView.setAdapter(personAdapter);

    }

    @Override
    public void errorData(String exception) {
        Toast.makeText(this, exception, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String[] getNamePerson() {
        return this.namePerson;
    }

    @Override
    public ArrayList<Person> getListPerson() {
        return this.listPerson;
    }

    @Override
    public void setListPerson(){

    }
}
