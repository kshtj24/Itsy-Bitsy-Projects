package apps.mrj.imdbsearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

/**
 * Created by kshtj on 24-03-2018.
 */

public class SearchResultAdapter extends BaseAdapter {

    static private Context mContext;
    private ArrayList<SearchResultHolder> data;
    private LayoutInflater inflater;
    private MainActivity mInstance;

    SearchResultAdapter(Context context, ArrayList<SearchResultHolder> tempList, MainActivity instance) {
        mContext = context;
        mInstance = instance;
        data = tempList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.search_results_view, viewGroup, false);
            ImageView imageView = view.findViewById(R.id.poster);
            TextView textView = view.findViewById(R.id.name_and_year);

            textView.setText(data.get(i).getTitle() + " (" + data.get(i).getYear() + ")");
            imageView.setContentDescription(data.get(i).getImdbID());
            createPosterRequest(data.get(i).getPosterURL(), imageView);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mInstance.getMovieData(view);
                }
            });
        }
        return view;
    }

    static void createPosterRequest(String url, final ImageView imageView) {
        final ImageLoader imageLoader = VolleySingleton.getInstance(mContext.getApplicationContext()).getImageLoader();
        imageLoader.get(url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                imageView.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, "Error occured in poster", Toast.LENGTH_SHORT).show();
                Log.e("ErrorIn", error.getMessage());
            }
        });
    }
}
