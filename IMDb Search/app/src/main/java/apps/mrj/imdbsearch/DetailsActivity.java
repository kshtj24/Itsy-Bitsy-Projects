package apps.mrj.imdbsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Field;

/**
 * Created by kshitij.saxena on 04-04-2018.
 */

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        Intent intent = getIntent();
        MovieDataHolder movieDataHolder = (MovieDataHolder) intent.getSerializableExtra("instance");

        TextView title, year, rated, released, runtime, genre, director, writer, actors, plot, language, country, awards, ratings, imdbRating, imdbVotes, imdbID, type, dvd, boxOfficeCollection, production, website;
        ImageView poster = findViewById(R.id.posterImage);
        title = findViewById(R.id.title);
        year = findViewById(R.id.year);
        rated = findViewById(R.id.rated);
        released = findViewById(R.id.released);
        runtime = findViewById(R.id.runtime);
        genre = findViewById(R.id.genre);
        director = findViewById(R.id.director);
        writer = findViewById(R.id.writer);
        actors = findViewById(R.id.actors);
        plot = findViewById(R.id.plot);
        language = findViewById(R.id.lang);
        country = findViewById(R.id.country);
        awards = findViewById(R.id.awards);
        ratings = findViewById(R.id.ratings);
        imdbRating = findViewById(R.id.imdbRating);
        imdbVotes = findViewById(R.id.imdbVotes);
        imdbID = findViewById(R.id.imdbID);
        type = findViewById(R.id.type);
        dvd = findViewById(R.id.dvd);
        boxOfficeCollection = findViewById(R.id.boxOfficeCollection);
        production = findViewById(R.id.production);
        website = findViewById(R.id.website);


        title.setText(movieDataHolder.getTitle());
        year.setText(movieDataHolder.getYear());
        rated.setText(movieDataHolder.getRated());
        released.setText(movieDataHolder.getReleased());
        runtime.setText(movieDataHolder.getRuntime());
        genre.setText(movieDataHolder.getGenre());
        director.setText(movieDataHolder.getDirector());
        writer.setText(movieDataHolder.getWriter());
        actors.setText(movieDataHolder.getActors());
        plot.setText(movieDataHolder.getPlot());
        language.setText(movieDataHolder.getLanguage());
        country.setText(movieDataHolder.getCountry());
        awards.setText(movieDataHolder.getAwards());
        ratings.setText(movieDataHolder.getRatings());
        imdbRating.setText(movieDataHolder.getImdbRating());
        imdbVotes.setText(movieDataHolder.getImdbVotes());
        imdbID.setText(movieDataHolder.getImdbID());
        type.setText(movieDataHolder.getType());
        dvd.setText(movieDataHolder.getDvd());
        boxOfficeCollection.setText(movieDataHolder.getBoxOfficeCollection());
        production.setText(movieDataHolder.getProduction());
        website.setText(movieDataHolder.getWebsite());

        SearchResultAdapter.createPosterRequest(movieDataHolder.getPosterURL(), poster);

    }
}
