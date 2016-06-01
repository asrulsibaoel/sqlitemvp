package com.penguin.padang.pasir.sqlitesharedpreferences.infrastructure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.penguin.padang.pasir.sqlitesharedpreferences.models.Person;

import java.util.ArrayList;

/**
 * Created by jowy on 6/1/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Mydb.db";
    public static final String PERSON_TABLE_NAME = "person";
    public static final String PERSON_COLUMN_ID = "id";
    public static final String PERSON_COLUMN_NAME = "name";
    public static final String PERSON_COLUMN_ADDRESS = "address";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + PERSON_TABLE_NAME + "" +
                "(" + PERSON_COLUMN_ID +" integer primary key," +
                PERSON_COLUMN_NAME+" text," +
                PERSON_COLUMN_ADDRESS+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop tables if exists " + PERSON_TABLE_NAME);
        onCreate(db);
    }

    public void addPerson(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(PERSON_COLUMN_NAME, person.getName());
        content.put(PERSON_COLUMN_ADDRESS, person.getAddress());

        db.insert(PERSON_TABLE_NAME, null, content);
    }

    public void updatePerson(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(PERSON_COLUMN_NAME, person.getName());
        content.put(PERSON_COLUMN_ADDRESS, person.getAddress());

        db.update(PERSON_TABLE_NAME,
                content, PERSON_COLUMN_ID + " = ? ",
                new String[]{Integer.toString(person.getId())});
    }

    public void deletePerson(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(PERSON_TABLE_NAME, PERSON_COLUMN_ID + " = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<Person> getAll(){
        ArrayList<Person> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + PERSON_TABLE_NAME, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            Person person = new Person();
            person.setId(cursor.getInt(0));
            person.setName(cursor.getString(1));
            person.setAddress(cursor.getString(2));

            arrayList.add(person);
            cursor.moveToNext();
        }

        return arrayList;
    }

    public Person getPersonById(int id){
        Person person = new Person();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + PERSON_TABLE_NAME + " where " + PERSON_COLUMN_ID + "=" + id, null);

        cursor.moveToFirst();

        if(cursor.getCount() <= 0){
            return null;
        }

        person.setId(cursor.getInt(0));
        person.setName(cursor.getString(1));
        person.setAddress(cursor.getString(2));

        return person;

    }
}
