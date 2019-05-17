package com.mr.j;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

public class CustomAdapter extends ArrayAdapter<UserItem> {

    private ArrayList<UserItem> userItems;

    public CustomAdapter(Context context, int textViewResourceId, ArrayList<UserItem> objects){
        super(context, textViewResourceId, objects);
        userItems = objects;
    }

    @Override
    public int getCount(){
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.user_list, null);

        TextView username = (TextView)view.findViewById(R.id.user_name);
        TextView userid = (TextView)view.findViewById(R.id.user_id);
        username.setText(userItems.get(position).getUsername());
        userid.setText(userItems.get(position).getUserid());

        return view;
    }

    public void addAll(ArrayList<UserItem> users){
        userItems.addAll(users);
    }

    @Override
    public void notifyDataSetChanged(){
        super.notifyDataSetChanged();
    }
}
