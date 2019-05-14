package com.mr.j;

import org.json.JSONArray;

public interface VolleyCallback {
    void onSuccessResponse(JSONArray result);

    void onErrorResponse(String error);
}
