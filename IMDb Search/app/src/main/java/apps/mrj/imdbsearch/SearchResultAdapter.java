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
 * File created by kshtj on 24-03-2018
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
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.search_results_view, viewGroup, false);
            holder.poster = view.findViewById(R.id.poster);
            holder.title = view.findViewById(R.id.name_and_year);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInstance.getMovieData(((ViewHolder) view.getTag()).poster.getContentDescription().toString());
            }
        });

        holder.title.setText(data.get(i).getTitle() + " (" + data.get(i).getYear() + ")");
        holder.poster.setContentDescription(data.get(i).getImdbID());
        if (data.get(i).getPosterURL().equals("N/A")) {
            holder.poster.setImageResource(R.drawable.ic_image_na);
            Log.e("NoImageFor", data.get(i).getTitle());
        } else
            createPosterRequest(data.get(i).getPosterURL(), holder.poster);

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
                Log.e("ErrorIn", error.toString());
            }
        });
    }

    //View Holder class for filling the view
    class ViewHolder {
        TextView title;
        ImageView poster;
    }
}
