package apps.mrj.imdbsearch;

import java.io.Serializable;

/**
 * Created by kshitij.saxena on 23-03-2018.
 */

class MovieDataHolder implements Serializable{
    private String title;
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String posterURL;
    private String ratings;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    private String type;
    private String dvd;
    private String boxOfficeCollection;
    private String production;
    private String website;

    String getTitle() {
        return title;
    }

    void setTitle(String str) {
        title = str;
    }

    String getYear() {
        return year;
    }

    void setYear(String str) {
        year = str;
    }

    String getRated() {
        return rated;
    }

    void setRated(String str) {
        rated = str;
    }

    String getReleased() {
        return released;
    }

    void setReleased(String str) {
        released = str;
    }

    String getRuntime() {
        return runtime;
    }

    void setRuntime(String str) {
        runtime = str;
    }

    String getGenre() {
        return genre;
    }

    void setGenre(String str) {
        genre = str;
    }

    String getDirector() {
        return director;
    }

    void setDirector(String str) {
        director = str;
    }

    String getWriter() {
        return writer;
    }

    void setWriter(String str) {
        writer = str;
    }

    String getActors() {
        return actors;
    }

    void setActors(String str) {
        actors = str;
    }

    String getPlot() {
        return plot;
    }

    void setPlot(String str) {
        plot = str;
    }

    String getLanguage() {
        return language;
    }

    void setLanguage(String str) {
        language = str;
    }

    String getCountry() {
        return country;
    }

    void setCountry(String str) {
        country = str;
    }

    String getAwards() {
        return awards;
    }

    void setAwards(String str) {
        awards = str;
    }

    String getPosterURL() {
        return posterURL;
    }

    void setPosterURL(String str) {
        posterURL = str;
    }

    String getRatings() {
        return ratings;
    }

    void setRatings(String str) {
        ratings = str;
    }

    String getImdbRating() {
        return imdbRating;
    }

    void setImdbRating(String str) {
        imdbRating = str;
    }

    String getImdbVotes() {
        return imdbVotes;
    }

    void setImdbVotes(String str) {
        imdbVotes = str;
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

    String getDvd() {
        return dvd;
    }

    void setDvd(String str) {
        dvd = str;
    }

    String getBoxOfficeCollection() {
        return boxOfficeCollection;
    }

    void setBoxOfficeCollection(String str) {
        boxOfficeCollection = str;
    }

    String getProduction() {
        return production;
    }

    void setProduction(String str) {
        production = str;
    }

    String getWebsite() {
        return website;
    }

    void setWebsite(String str) {
        website = str;
    }
}
