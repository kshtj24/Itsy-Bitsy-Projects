package apps.mrj.imdbsearch;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import static apps.mrj.imdbsearch.Constants.*;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchButtonOnClick(View view) {
        EditText searchBox = findViewById(R.id.searchBox);
        String searchURL = MAIN_URL_HEAD + searchBox.getText().toString().replace(" ", "+") + MAIN_URL_TAIL;
        createJSONRequest(searchURL);
    }

    void createJSONRequest(String url) {
        Response.Listener<JSONObject> response = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(MainActivity.this, "Response received", Toast.LENGTH_SHORT).show();
            }
        };

        Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error occured", Toast.LENGTH_SHORT).show();
            }
        };

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, response, error);

        VolleySingleton.getInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest, Constants.REQUEST_TAG);
    }

}
