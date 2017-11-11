package com.example.alex.myrestourant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Alex on 23.10.2017.
 */

public class ListAdapterForTable2 extends ArrayAdapter<TableWorkersDataClass> {
    private LayoutInflater inflater;
    private Context context;
    private int layout;
    ArrayList<TableWorkersDataClass> array=new ArrayList<TableWorkersDataClass>();
    public ListAdapterForTable2(Context context, int resource, ArrayList<TableWorkersDataClass>table){
        super(context, resource, table);
        this.inflater=LayoutInflater.from(context);
        this.layout=resource;
        this.array=table;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View view=inflater.inflate(this.layout, parent, false);
        TextView name1=(TextView)view.findViewById(R.id.Name2);
        TextView orders=(TextView) view.findViewById(R.id.Orders2);
        TextView dur_of_work=(TextView) view.findViewById(R.id.DurOfWork2);
        TextView change=(TextView) view.findViewById(R.id.Change2);
        ImageView foto=(ImageView) view.findViewById(R.id.Foto2);

        TableWorkersDataClass el=array.get(position);

        name1.setText(el.getName());
        orders.setText(Long.toString(el.getOrders()));
        dur_of_work.setText(Long.toString(el.getDuration_of_work()));
        change.setText(el.getChange_worker());
        Glide.with(view.getContext()).load(el.getFoto()).into(foto);
        return view;
    }
}
