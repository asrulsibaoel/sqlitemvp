package com.penguin.padang.pasir.sqlitesharedpreferences.views.imp;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.penguin.padang.pasir.sqlitesharedpreferences.R;
import com.penguin.padang.pasir.sqlitesharedpreferences.views.imp.fragments.MemberFragment;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id.content);

        if(fragment == null){
            fragment = MemberFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, fragment, "")
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .attach(fragment)
                    .commit();
        }
    }
}
