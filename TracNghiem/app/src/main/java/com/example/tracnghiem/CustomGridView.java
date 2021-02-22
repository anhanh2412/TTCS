package com.example.tracnghiem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomGridView extends ArrayAdapter<Contact>{
    Context context;
    int resource;
    ArrayList<Contact> arrayList;

    public CustomGridView(@NonNull Context context, int resource, @NonNull ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        TextView text_name = convertView.findViewById(R.id.text_name);
        ImageButton imbt = convertView.findViewById(R.id.imbt);

        text_name.setText(arrayList.get(position).getName());
        imbt.setImageResource(arrayList.get(position).getImg());
        return convertView;
    }
}
