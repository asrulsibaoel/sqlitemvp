package com.penguin.padang.pasir.sqlitesharedpreferences.views.imp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.penguin.padang.pasir.sqlitesharedpreferences.R;
import com.penguin.padang.pasir.sqlitesharedpreferences.presenters.PersonPresenterImp;
import com.penguin.padang.pasir.sqlitesharedpreferences.presenters.PersonPresenterInterface;
import com.penguin.padang.pasir.sqlitesharedpreferences.views.interfaces.MainActivityInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityInterface{

    private PersonPresenterInterface personPresenter;
    private SharedPreferences sharedPreferences;
    Button submit;
    Button viewRegistered;
    Button viewList;
    EditText name;
    EditText address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //init SharedPreferences;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IS_LOGGED_IN", true);

        editor.apply();

        //get SharedPreferences;

        Boolean isLoggedIn = sharedPreferences.getBoolean("IS_LOGGED_IN", false);

        //editor.clear(); //remove all session;
        //editor.apply(); //apply changes;


        personPresenter = new PersonPresenterImp(this);

        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        submit = (Button) findViewById(R.id.submit_registration);
        viewRegistered = (Button) findViewById(R.id.view_registered);
        viewList = (Button) findViewById(R.id.list_person);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personPresenter.addPersonAction(name.getText().toString(), address.getText().toString());
            }
        });

        viewRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personPresenter.viewAllRegisteredAction();
            }
        });

        viewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewAcivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void addPersonSuccess() {
        Toast.makeText(this, "Person successfully added!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showValidationError(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addPersonError(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }
}
