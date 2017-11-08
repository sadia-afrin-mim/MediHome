package com.example.esha.medihome.DoctorInfo;
import android.app.Activity;
import android.support.annotation.NonNull;
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

import android.widget.ArrayAdapter;

/**
 * Created by fatema on 11/8/17.
 */

public class ListViewOfDoctor extends ArrayAdapter<Doctor> {
    private Activity context;
    private List<Doctor> artistlist;

    public ListViewOfDoctor(Activity context, List<Doctor> artistList) {
        super(context, R.layout.list_view_of_doctor, artistList);
        this.context = context;
        this.artistlist = artistList;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_of_doctor, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);
        TextView textViewPhone = (TextView) listViewItem.findViewById(R.id.textViewPhone);
        TextView textViewType = (TextView) listViewItem.findViewById(R.id.textViewType);
        Doctor artist = artistlist.get(position);
        textViewName.setText(artist.getDoctorName());
        textViewGenre.setText(artist.getDoctorGenre());

        textViewType.setText(artist.getDoctorPhone());
        textViewPhone.setText(artist. getDoctorCatagory());



        return listViewItem;
    }

}
