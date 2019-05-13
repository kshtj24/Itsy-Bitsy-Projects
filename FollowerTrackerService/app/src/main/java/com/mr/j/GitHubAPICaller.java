package com.mr.j;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;

public class GitHubAPICaller {

    RequestQueue requestQueue;
    JsonArrayRequest arrayRequest;

    private void callAPI(String url, String user, int pageNo, final VolleyCallback callback) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, String.format(url, user, pageNo), "", new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                callback.onSuccessResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }

    private JSONObject getFollowers(String user, int pageNo) {
        return null;
    }

    private JSONObject getFollowing(String user, int pageNo) {
        return null;
    }

    protected ArrayList<String> getValues(String user, int type, int pageNo) {
        JSONObject response = new JSONObject();
        switch (type) {
            case 0:
                response = getFollowers(user, pageNo);
                break;

            case 1:
                response = getFollowing(user, pageNo);
                break;
        }

        return null;
    }

    private ArrayList<String> parseJSONObj(JSONObject response) {
        return null;
    }
}
