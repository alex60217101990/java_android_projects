package com.example.alex.myrestourant;

import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.alex.myrestourant.MainActivity.table1_static;
import static com.example.alex.myrestourant.MainActivity.table2_static;


/**
 * Created by Alex on 29.10.2017.
 */

public class Fragment4 extends Fragment {
    private AnimationDrawable mAnimationDrawable;
    private DBConnectorAll db;
    private long position_in_table2=0;
    private ArrayList<TableMenuDataClass> table1 = new ArrayList<>();
    private ArrayList<TableWorkersDataClass>table2=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.delete_fragment, null);

        RelativeLayout imageView = (RelativeLayout) view.findViewById(R.id.del_cont);
        imageView.setBackgroundResource(R.drawable.animation_list_3);

        mAnimationDrawable = (AnimationDrawable) imageView.getBackground();
        mAnimationDrawable.start();
        // адаптер 1
        String []data=new String[table1_static.size()];
        int i=0;
        for (TableMenuDataClass a:table1_static){
            data[i++]=a.getName();
        }
        // адаптер 2
        String []data1=new String[table2_static.size()];
        int j=0;
        for (TableWorkersDataClass a:table2_static){
            data1[j++]=a.getName().split("[А-Я][а-я]+?")[0];
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, data1);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner2);
        spinner1.setAdapter(adapter1);
        // заголовок
        spinner1.setPrompt("Menu worker's for delete");
        // выделяем элемент
        spinner1.setSelection(1);
        // устанавливаем обработчик нажатия
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       final int position, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(view.getContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
                position_in_table2=position;
              /*  try{
                    db=new DBConnectorAll(view.getContext());
                    Thread t=new Thread(new Runnable() {
                        @Override
                        public void run() {
                            table2=db.selectAllTable2();
                            table2.remove(position);
                        }
                    }); t.start();

                }catch (Exception e){
                    Toast.makeText(view.getContext(), "delete error", Toast.LENGTH_SHORT).show();
                }*/
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });



      //  Toast.makeText(view.getContext(), ""+data.length, Toast.LENGTH_SHORT).show();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(/*android.R.layout.simple_spinner_dropdown_item*/R.layout.spinner_dropdown_item);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Menu elements for delete");
        // выделяем элемент
        spinner.setSelection(2);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(view.getContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        return view;
    }
}
