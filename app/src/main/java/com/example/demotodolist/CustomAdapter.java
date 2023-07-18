package com.example.demotodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

class CustomAdapter extends ArrayAdapter<ToDoItem> {

    Context context;
    ArrayList<ToDoItem> al;
    int resource;

    public CustomAdapter(Context context, int resource, ArrayList<ToDoItem> al) {
        super(context, resource, al);
        this.context = context;
        this.resource = resource;
        this.al = al;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        ToDoItem current = al.get(position);

        tvTitle.setText(current.getTitle());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy (EEEE)", Locale.getDefault());
        String Date = sdf.format(current.getDate().getTime());
        tvDate.setText(Date);

        return rowView;
    }
}

