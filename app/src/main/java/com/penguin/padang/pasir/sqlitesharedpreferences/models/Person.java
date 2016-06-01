package com.penguin.padang.pasir.sqlitesharedpreferences.models;

/**
 * Created by jowy on 6/1/16.
 */
public class Person {

    Integer id;
    String name;
    String address;

    public Person(){

    }

    public Person( String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
