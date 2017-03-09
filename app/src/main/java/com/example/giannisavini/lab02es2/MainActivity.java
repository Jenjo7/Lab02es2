package com.example.giannisavini.lab02es2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BasicFragment.onBasicFragmentInteraction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        BasicFragment fragment = BasicFragment.newIstance(10);
        transaction.add(R.id.layout_base, fragment);
        transaction.commit();
    }

    @Override
    public void onButtonClick(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().popBackStack();
    }
}
