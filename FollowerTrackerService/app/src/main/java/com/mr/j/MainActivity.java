package com.mr.j;


import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    ArrayAdapter<String> followersListAdapter;
    ListView followersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isFirstRun()) {
            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.userid_dialog);
            dialog.setTitle(Constants.dialogTitle);

            final EditText userId = dialog.findViewById(R.id.userId_EditTxt);
            Button setButton = dialog.findViewById(R.id.setButton);

            setButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editSharedPreferences(Constants.userIdKey, userId.getText().toString());
                    Toast.makeText(MainActivity.this, "UserId set", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    getFollowers(1);

                }
            });

            Toast.makeText(MainActivity.this, R.string.user_id_toast, Toast.LENGTH_LONG).show();
            dialog.show();
        }

        initializeComponents();
    }


    private String getSharedPreferencesValue(String key) {
        sharedPreferences = getSharedPreferences(Constants.preferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    private <T> void editSharedPreferences(String keyName, T value) {

        sharedPreferences = getSharedPreferences(Constants.preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (value instanceof String)
            editor.putString(keyName, value.toString());
        else
            editor.putBoolean(keyName, Boolean.parseBoolean(value.toString()));
        editor.apply();
    }

    private boolean isFirstRun() {
        sharedPreferences = getSharedPreferences(Constants.preferenceName, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Constants.isFirstRun)) {
            editSharedPreferences(Constants.isFirstRun, true);
            return false;
        }

        return true;
    }

    private void initializeComponents() {
        try {
            Constants.userIdValue = getSharedPreferencesValue(Constants.userIdKey);
        } catch (Exception e) {
            Log.e("Error", "initializeComponents: " + e.getMessage());
        }

        followersList = findViewById(R.id.followersList);
        followersListAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
    }

    /*----API Calling methods----*/
    private void getFollowers(int pageNo) {
        GitHubAPICaller caller = new GitHubAPICaller(MainActivity.this);
        caller.getResponse(String.format(Constants.followerUrl, Constants.userIdValue, pageNo), new VolleyCallback() {
            @Override
            public void onSuccessResponse(JSONArray result) {
                Toast.makeText(MainActivity.this,result.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onErrorResponse(String error) {
            Toast.makeText(MainActivity.this, "Error occurred", Toast.LENGTH_LONG).show();
        }
    });
    }

    private void getFollowing() {

    }
}