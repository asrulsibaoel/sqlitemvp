package com.penguin.padang.pasir.sqlitesharedpreferences.presenters;

import com.penguin.padang.pasir.sqlitesharedpreferences.models.Person;

/**
 * Created by jowy on 6/1/16.
 */
public interface PersonPresenterInterface {

    void addPersonAction(String name, String address);

    void deletePersonAction(int id);

    void updatePersonAction(int id, String name, String address);

    void viewAllRegisteredAction();
}
