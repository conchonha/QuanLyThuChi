package com.example.baseprojectandroid.src.adapter.spinner_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.models.spinner_model.SpinnerModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<SpinnerModel> {

    public SpinnerAdapter(Context context, List<SpinnerModel> listSpinner) {
        super(context, 0, listSpinner);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_spinner, parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.img_spinner);
        TextView textView = convertView.findViewById(R.id.txt_spinner);

        SpinnerModel spinnerModel = getItem(position);
        if (spinnerModel != null) {
            Picasso.with(getContext()).load(spinnerModel.getmImageIcon()).into(imageView);
            textView.setText(spinnerModel.getmContent());
        }

        return convertView;
    }
}
