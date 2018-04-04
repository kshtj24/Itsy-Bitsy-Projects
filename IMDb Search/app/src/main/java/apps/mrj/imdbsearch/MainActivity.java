package apps.mrj.imdbsearch;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.util.ArrayList;

import static apps.mrj.imdbsearch.Constants.*;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    boolean isSearch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchButtonOnClick(View view) {
        EditText searchBox = findViewById(R.id.searchBox);
        String searchURL = SEARCH_URL_HEAD + searchBox.getText().toString().replace(" ", "+") + SEARCH_URL_TAIL;
        createJSONRequest(searchURL);
        isSearch = true;
    }

    public void getMovieData(String itemID) {
        //view.getTag().getClass().getDeclaredFields()[0]).getText();
        // /ImageView imageView = view.findViewById(R.id.poster);
        //String itemID = imageView.getContentDescription().toString();
        String itemURL = ITEM_URL_HEAD + itemID + ITEM_URL_TAIL;
        createJSONRequest(itemURL);
        isSearch = false;
    }

    void createJSONRequest(String url) {

        Response.Listener<JSONObject> response = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("Response", "Received");
                try {
                    parseJSONResponse(response);
                } catch (JSONException ex) {
                    Log.e(JSON_EXCEPTION, ex.getMessage());
                }
            }
        };

        Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VolleyError", error.getMessage());
            }
        };

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, response, error);

        VolleySingleton.getInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest, Constants.REQUEST_TAG);
    }

    void parseJSONResponse(JSONObject response) throws JSONException {
        if (isSearch) {
            ArrayList<SearchResultHolder> searchResultHolders = new ArrayList<>();
            JSONArray jsonArray = response.getJSONArray("Search");
            for (int i = 0; i < jsonArray.length(); i++) {
                SearchResultHolder tempHolder = new SearchResultHolder();

                JSONObject tempJsonObject = jsonArray.getJSONObject(i);
                tempHolder.setTitle(tempJsonObject.getString("Title"));
                tempHolder.setImdbID(tempJsonObject.getString("imdbID"));
                tempHolder.setPosterURL(tempJsonObject.getString("Poster"));
                tempHolder.setType(tempJsonObject.getString("Type"));
                tempHolder.setYear(tempJsonObject.getString("Year"));

                searchResultHolders.add(tempHolder);
            }
            GridView searchResultGrid = findViewById(R.id.searchResultGrid);
            SearchResultAdapter searchResultAdapter = new SearchResultAdapter(getApplicationContext(), searchResultHolders, MainActivity.this);
            searchResultGrid.setAdapter(searchResultAdapter);

        } else {
            fillMovieDataHolder(response);
        }
    }

    void fillMovieDataHolder(JSONObject response) throws JSONException {
        MovieDataHolder movieDataHolder = new MovieDataHolder();
        movieDataHolder.setTitle(response.getString("Title"));
        movieDataHolder.setYear(response.getString("Year"));
        movieDataHolder.setRated(response.getString("Rated"));
        movieDataHolder.setReleased(response.getString("Released"));
        movieDataHolder.setRuntime(response.getString("Runtime"));
        movieDataHolder.setGenre(response.getString("Genre"));
        movieDataHolder.setDirector(response.getString("Director"));
        movieDataHolder.setWriter(response.getString("Writer"));
        movieDataHolder.setActors(response.getString("Actors"));
        movieDataHolder.setPlot(response.getString("Plot"));
        movieDataHolder.setLanguage(response.getString("Language"));
        movieDataHolder.setCountry(response.getString("Country"));
        movieDataHolder.setAwards(response.getString("Awards"));
        movieDataHolder.setPosterURL(response.getString("Poster"));
        movieDataHolder.setRatings(response.getString("Ratings"));
        movieDataHolder.setImdbRating(response.getString("imdbRating"));
        movieDataHolder.setImdbVotes(response.getString("imdbVotes"));
        movieDataHolder.setImdbID(response.getString("imdbID"));
        movieDataHolder.setType(response.getString("Type"));
        movieDataHolder.setDvd(response.getString("DVD"));
        movieDataHolder.setBoxOfficeCollection(response.getString("BoxOffice"));
        movieDataHolder.setProduction(response.getString("Production"));
        movieDataHolder.setWebsite(response.getString("Website"));

        Log.i("Movie ", "data updated");
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("instance", movieDataHolder);
        startActivity(intent);
    }
}
