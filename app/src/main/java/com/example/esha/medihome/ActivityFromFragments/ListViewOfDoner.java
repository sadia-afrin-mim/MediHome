package com.example.esha.medihome.ActivityFromFragments;

/**
 * Created by fatema on 11/8/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.esha.medihome.Others.doner;
import com.example.esha.medihome.R;


import java.util.List;

import static com.example.esha.medihome.R.id.call;

/**
 * Created by esha on 07/11/17.
 */

public class ListViewOfDoner  extends ArrayAdapter<doner>{
    private Activity context;
    private List<doner> artistlist;

    public ListViewOfDoner(Activity context, List<doner> artistList) {
        super(context, R.layout.activity_list_view_of_doner, artistList);
        this.context = context;
        this.artistlist = artistList;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_list_view_of_doner, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);
        TextView textViewPhone = (TextView) listViewItem.findViewById(R.id.textViewPhone);
        TextView textViewType = (TextView) listViewItem.findViewById(R.id.textViewType);
        Button button=(Button) listViewItem.findViewById(call);


        doner artist = artistlist.get(position);
        textViewName.setText(artist.getName());
        textViewGenre.setText(artist.getBloodgroup());

        textViewType.setText(artist.getMobile());
        textViewPhone.setText(artist. getLastdon());
        return listViewItem;
    }

}
