package apps.mrj.imdbsearch;

/**
 * Created by kshtj on 24-03-2018.
 */

public class SearchResultHolder {
    private String title;
    private String year;
    private String imdbID;
    private String type;
    private String posterURL;

    public String getTitle() {
        return title;
    }

    public void setTitle(String str) {
        title = str;
    }

    String getImdbID() {
        return imdbID;
    }

    void setImdbID(String str) {
        imdbID = str;
    }

    String getType() {
        return type;
    }

    void setType(String str) {
        type = str;
    }

    String getPosterURL() {
        return posterURL;
    }

    void setPosterURL(String str) {
        posterURL = str;
    }

    String getYear() {
        return year;
    }

    void setYear(String str) {
        year = str;
    }
}
