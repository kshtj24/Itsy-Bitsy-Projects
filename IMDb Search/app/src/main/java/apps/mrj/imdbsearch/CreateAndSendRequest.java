package apps.mrj.imdbsearch;

import android.content.Context;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static apps.mrj.imdbsearch.Constants.JSONEXCEPTION;

/**
 * Created by kshtj on 25-03-2018.
 */

public class CreateAndSendRequest {

//    static boolean isSearch = false;
//    //static String url = "";
//    static Context mContext;
//
//    static void createJSONRequest(String url, final Context context) {
//        mContext = context;
//        Response.Listener<JSONObject> response = new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Toast.makeText(context, "Response received", Toast.LENGTH_SHORT).show();
//                try {
//                    parseJSONResponse(response);
//                } catch (JSONException ex) {
//                    Log.e(JSONEXCEPTION, ex.getMessage());
//                }
//            }
//        };
//
//        Response.ErrorListener error = new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, response, error);
//
//        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest, Constants.REQUEST_TAG);
//    }
//
//    static void parseJSONResponse(JSONObject response) throws JSONException {
//        if (isSearch) {
//            ArrayList<SearchResultHolder> searchResultHolders = new ArrayList<>();
//            JSONArray jsonArray = response.getJSONArray("Search");
//            for (int i = 0; i < jsonArray.length(); i++) {
//                SearchResultHolder tempHolder = new SearchResultHolder();
//
//                JSONObject tempJsonObject = jsonArray.getJSONObject(i);
//                tempHolder.setTitle(tempJsonObject.getString("Title"));
//                tempHolder.setImdbID(tempJsonObject.getString("imdbID"));
//                tempHolder.setPosterURL(tempJsonObject.getString("Poster"));
//                tempHolder.setType(tempJsonObject.getString("Type"));
//                tempHolder.setYear(tempJsonObject.getString("Year"));
//
//                searchResultHolders.add(tempHolder);
//            }
//            GridView searchResultGrid = findViewById(R.id.searchResultGrid);
//            SearchResultAdapter searchResultAdapter = new SearchResultAdapter(context.getApplicationContext(), searchResultHolders);
//            searchResultGrid.setAdapter(searchResultAdapter);
//
//        } else {
//            MovieDataHolder movieDataHolder = new MovieDataHolder();
//            movieDataHolder.setTitle(response.getString("Title"));
//            movieDataHolder.setYear(response.getString("Year"));
//            movieDataHolder.setRated(response.getString("Rated"));
//            movieDataHolder.setReleased(response.getString("Released"));
//            movieDataHolder.setRuntime(response.getString("Runtime"));
//            movieDataHolder.setGenre(response.getString("Genre"));
//            movieDataHolder.setDirector(response.getString("Director"));
//            movieDataHolder.setWriter(response.getString("Writer"));
//            movieDataHolder.setActors(response.getString("Actors"));
//            movieDataHolder.setPlot(response.getString("Plot"));
//            movieDataHolder.setLanguage(response.getString("Language"));
//            movieDataHolder.setCountry(response.getString("Country"));
//            movieDataHolder.setAwards(response.getString("Awards"));
//            movieDataHolder.setPosterURL(response.getString("Poster"));
//            movieDataHolder.setRatings(response.getString("Ratings"));
//            movieDataHolder.setImdbRating(response.getString("imdbRating"));
//            movieDataHolder.setImdbVotes(response.getString("imdbVotes"));
//            movieDataHolder.setImdbID(response.getString("imdbID"));
//            movieDataHolder.setType(response.getString("Type"));
//            movieDataHolder.setDvd(response.getString("DVD"));
//            movieDataHolder.setBoxOfficeCollection(response.getString("BoxOffice"));
//            movieDataHolder.setProduction(response.getString("Production"));
//            movieDataHolder.setWebsite(response.getString("Website"));
//        }
//    }
}
