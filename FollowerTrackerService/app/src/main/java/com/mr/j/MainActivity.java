package com.mr.j;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isFirstRun()){

        }


    }

    private boolean isFirstRun() {
        sharedPreferences = getSharedPreferences(Constants.preferenceName, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Constants.isFisrtRun)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(Constants.isFisrtRun, true);
            editor.apply();
            return true;
        }

        return false;
    }

    private void intializeComponents() {

    }
}