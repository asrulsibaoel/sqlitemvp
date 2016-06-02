package com.penguin.padang.pasir.sqlitesharedpreferences.presenters;

import android.content.Context;
import android.widget.ListView;

import com.penguin.padang.pasir.sqlitesharedpreferences.R;
import com.penguin.padang.pasir.sqlitesharedpreferences.infrastructure.DatabaseHelper;
import com.penguin.padang.pasir.sqlitesharedpreferences.infrastructure.PersonAdapter;
import com.penguin.padang.pasir.sqlitesharedpreferences.models.Person;
import com.penguin.padang.pasir.sqlitesharedpreferences.views.imp.ListViewAcivity;
import com.penguin.padang.pasir.sqlitesharedpreferences.views.interfaces.ListViewActivityInterface;

import java.util.ArrayList;

/**
 * Created by jowy on 6/2/16.
 */
public class PersonListImp implements PersonListInterface{
    private ListViewActivityInterface listViewActivityInterface;
    private DatabaseHelper dbHelper;
    public PersonAdapter personAdapter;
    private ListView listView;

    public PersonListImp(ListViewActivityInterface listViewActivityInterface, ListView listView) {
        this.listViewActivityInterface = listViewActivityInterface;
        this.listView = listView;
    }

    @Override
    public void showAllPerson() {
        dbHelper = new DatabaseHelper((Context) listViewActivityInterface);
        ArrayList<Person> arrayList = dbHelper.getAll();

        try {
            if(arrayList.size() > 0){
                for (int i = 0; i < arrayList.size(); i++) {
                    Person person = arrayList.get(i);
                    listViewActivityInterface.getListPerson().add(person);
                }
            }

            personAdapter = new PersonAdapter((Context) listViewActivityInterface, R.layout.view_item_layout, listViewActivityInterface.getListPerson());

            listView.setAdapter(personAdapter);
        } catch (Exception  e) {
            listViewActivityInterface.errorData(e.getMessage());
        }
    }

    @Override
    public void viewAllRegisteredAction() {
        dbHelper = new DatabaseHelper((Context) listViewActivityInterface);
        ArrayList<Person> arrayList = dbHelper.getAll();

        if(arrayList.size() > 0){
            Person person = arrayList.get(2);
            System.out.println(person.getName()+ "," + person.getAddress());
        }
    }
}
