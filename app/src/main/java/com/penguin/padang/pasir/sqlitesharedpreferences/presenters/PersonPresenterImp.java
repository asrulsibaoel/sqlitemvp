package com.penguin.padang.pasir.sqlitesharedpreferences.presenters;

import android.content.Context;

import com.penguin.padang.pasir.sqlitesharedpreferences.infrastructure.helper.DatabaseHelper;
import com.penguin.padang.pasir.sqlitesharedpreferences.models.Person;
import com.penguin.padang.pasir.sqlitesharedpreferences.views.interfaces.MainActivityInterface;

import java.util.ArrayList;

/**
 * Created by jowy on 6/1/16.
 */
public class PersonPresenterImp implements PersonPresenterInterface {

    private MainActivityInterface mainActivity;
    DatabaseHelper dbHelper;

    public PersonPresenterImp(MainActivityInterface main){
        this.mainActivity = main;
    }

    @Override
    public void addPersonAction(String name, String address) {

        Person person = new Person(name, address);
        try {
            dbHelper = new DatabaseHelper((Context) mainActivity);
            dbHelper.addPerson(person);
            mainActivity.addPersonSuccess();
        }catch (Exception e) {
            mainActivity.addPersonError(e.getMessage());
        }
    }

    @Override
    public void deletePersonAction(int id) {

    }

    @Override
    public void updatePersonAction(int id, String name, String address) {

    }

    @Override
    public void viewAllRegisteredAction() {
        dbHelper = new DatabaseHelper((Context) mainActivity);
        ArrayList<Person> arrayList = dbHelper.getAll();

        if(arrayList.size() > 0){
            Person person = arrayList.get(2);
            System.out.println(person.getName()+ "," + person.getAddress());
        }
    }
}
