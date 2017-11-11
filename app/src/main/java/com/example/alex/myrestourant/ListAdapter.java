package com.example.alex.myrestourant;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.R.attr.data;

/**
 * Created by Alex on 21.10.2017.
 */

public class ListAdapter extends ArrayAdapter<TableMenuDataClass> {
    private Context context;
    private LayoutInflater inflater;
    private int layout;
    ArrayList<TableMenuDataClass> arreyForTable_2_obj;

/*1 table method's*/
    public ListAdapter(Context context, int resource, ArrayList<TableMenuDataClass> elements) {
        super(context, resource, elements);
        this.arreyForTable_2_obj=elements;
        this.layout=resource;
        this.inflater=LayoutInflater.from(context);
    }
    // осталось только переопределить процедуру создания элемента view, по сути адаптер нужен просто
    // чтобы создать itemView для ListView
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

  //      TextView id = (TextView) view.findViewById(R.id.Id);
        TextView name = (TextView) view.findViewById(R.id.Name);
        TextView price= (TextView) view.findViewById(R.id.Price);
        TextView date= (TextView) view.findViewById(R.id.Date);
        TextView type= (TextView) view.findViewById(R.id.time_type);
        TextView time_of_day=(TextView) view.findViewById(R.id.time_of_day);
        ImageView icon = (ImageView) view.findViewById(R.id.Icon);

        TableMenuDataClass state = arreyForTable_2_obj.get(position);

      //  id.setText(Long.toString(state.getId()));
        name.setText(state.getName());
        price.setText(Double.toString(state.getPrice()));
        date.setText(Long.toString(state.getDate()));
        type.setText(state.getTime_type());
        time_of_day.setText(state.getChange());
        Glide.with(view.getContext()).load(state.getIcon()).into(icon);
        return view;
    }
    /*1 table method's*/
}
