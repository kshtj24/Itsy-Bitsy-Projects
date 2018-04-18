package apps.mrj.imdbsearch;

/**
 * File created by kshitij.saxena on 23-03-2018
 */

class Constants {
    static String SEARCH_URL_HEAD = "http://www.omdbapi.com/?apikey=995e2440&s=";
    static String PAGE = "&page=";
    static String SEARCH_URL_TAIL = "&plot=full&r=json";
    static String ITEM_URL_HEAD = "http://omdbapi.com/?apikey=995e2440&i=";
    static String ITEM_URL_TAIL = "&plot=full";
    static String JSON_EXCEPTION = "JSONException";
    static String REQUEST_TAG = "com.apps.mrj.imdbsearch";
}
