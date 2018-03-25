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

    public String getTitle(){
        return title;
    }

    public void setTitle(String str){
        title = str;
    }

    public String getImdbID(){
        return imdbID;
    }
    public void setImdbID(String str){
        imdbID = str;
    }

    public String getType(){
        return type;
    }
    public void setType(String str){
        type = str;
    }

    public String getPosterURL(){
        return posterURL;
    }
    public void setPosterURL(String str){
        posterURL = str;
    }


    public String getYear(){
        return year;
    }
    public void setYear(String str){
        year = str;
    }
}
