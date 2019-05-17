package com.mr.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

class GitHubAPICaller {

    RequestQueue requestQueue;
    JsonArrayRequest arrayRequest;
    Context context;

    GitHubAPICaller(Context context) {
        this.context = context;
    }

    void getResponse(String url, final VolleyCallback callback) {

        requestQueue = Singleton.getInstance(context).getRequestQueue();

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, "", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                callback.onSuccessResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onErrorResponse(error.getMessage());
            }
        });

        Singleton.getInstance(context).addToRequestQueue(jsonObjectRequest);

    }

    void getImage(String url, final VolleyCallback callback) {
        requestQueue = Singleton.getInstance(context).getRequestQueue();

        ImageLoader imageLoader = new ImageLoader(url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                callback.onImageResponse(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onErrorResponse(error.getMessage());
            }
        });
    }

//    private JSONObject getFollowers(String user, int pageNo) {
//        return null;
//    }
//
//    private JSONObject getFollowing(String user, int pageNo) {
//        return null;
//    }
//
//    protected ArrayList<String> getValues(String user, int type, int pageNo) {
//        JSONObject response = new JSONObject();
//        switch (type) {
//            case 0:
//                response = getFollowers(user, pageNo);
//                break;
//
//            case 1:
//                response = getFollowing(user, pageNo);
//                break;
//        }
//
//        return null;
//    }

//    private ArrayList<String> parseJSONObj(JSONObject response) {
//        return null;
//    }
}
