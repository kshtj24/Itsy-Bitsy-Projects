package com.mr.j;


import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    ListView followersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isFirstRun()) {
            Dialog dialog = new Dialog(getApplicationContext());
            dialog.setContentView(R.layout.userid_dialog);
            dialog.setTitle(Constants.dialogTitle);

            final EditText userId = dialog.findViewById(R.id.userId_EditTxt);
            Button setButton = dialog.findViewById(R.id.setButton);

            setButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editSharedPreferences(Constants.userIdKey, userId.getText());
                }
            });

            Toast.makeText(getApplicationContext(), R.string.user_id_toast, Toast.LENGTH_LONG);
            dialog.show();
        }
    }

//
//    private String getSharedPreferencesValue(String key){
//        sharedPreferences = getSharedPreferences(Constants.preferenceName,Context.MODE_PRIVATE);
//
//        return "";
//    }

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
            return true;
        }

        return false;
    }



    private void intializeComponents() {

    }
}