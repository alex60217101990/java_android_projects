package com.example.alex.myrestourant;


import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;



/**
 * Created by Alex on 25.10.2017.
 */

public class Fragment2 extends Fragment {
    DBConnectorAll db;
    ListAdapter elements_t1;
    ArrayList<TableMenuDataClass> table1 = new ArrayList<TableMenuDataClass>();
    private int proverka=0;
    private AnimationDrawable mAnimationDrawable;
    private long t_id;
    private String t_name;
    private double t_price;
    public static int sinchronization;
    private long t_date;
    private String t_type;
    private String t_change;
    private String t_icon;
    EditText editText1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.add_in_dbase, null);
    //logic of content...
        LinearLayout imageView = (LinearLayout) view.findViewById(R.id.cont);
        imageView.setBackgroundResource(R.drawable.animation_list_1);

        mAnimationDrawable = (AnimationDrawable) imageView.getBackground();
        mAnimationDrawable.start();

        Button enter=(Button) view.findViewById(R.id.button3);
        enter.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] str1 = new String[6];
                editText1 = (EditText) view.findViewById(R.id.t1);
                str1[0] = editText1.getText().toString();
                if (str1[0].length() > 0 && str1[0].matches("^([А-ЯЁ][а-яё]+\\s?){1,}$")) {
                    t_name = editText1.getText().toString();
                    proverka++;
                } else {
                    Toast toast = Toast.makeText(view.getContext(), str1[0] + "-incorect name", Toast.LENGTH_SHORT);
                    toast.show();
                }
                editText1 = (EditText) view.findViewById(R.id.t2);
                str1[1] = editText1.getText().toString();
                if (str1[1].length() > 0 && str1[1].matches("^[0-9]+[.,]?[0-9]+$")) {
                    try {
                        t_price = Double.valueOf(editText1.getText().toString());
                        proverka++;
                    } catch (Exception e) {
                        Toast toast = Toast.makeText(view.getContext(), str1[1] + "-incorect price", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(view.getContext(), str1[1] + "-incorect price", Toast.LENGTH_SHORT);
                    toast.show();
                }
                editText1 = (EditText) view.findViewById(R.id.t3);
                str1[2] = editText1.getText().toString();
                if (str1[2].length() > 0 && str1[2].matches("^(0[1-9]|1[0-9]|2[0-9]|3[01])(0[1-9]|1[012])[0-9]{4}\\s?$")) {
                    try {
                        t_date = Long.valueOf(editText1.getText().toString());
                        proverka++;
                    } catch (Exception e) {
                        Toast toast = Toast.makeText(view.getContext(), str1[2] + "-incorect date", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(view.getContext(), str1[2] + "-incorect date", Toast.LENGTH_SHORT);
                    toast.show();
                }
                editText1 = (EditText) view.findViewById(R.id.t4);
                str1[3] = editText1.getText().toString();
                if (str1[3].length() > 0 && str1[3].matches("^[А-ЯЁ]?[а-яё]+\\s?$")) {
                    t_type = editText1.getText().toString();
                    proverka++;
                } else {
                    Toast toast = Toast.makeText(view.getContext(), str1[3] + "-incorect type of dish", Toast.LENGTH_SHORT);
                    toast.show();
                }
                editText1 = (EditText) view.findViewById(R.id.t5);
                str1[4] = editText1.getText().toString();
                if (str1[4].length() > 0 && str1[4].matches("^[А-ЯЁ]?[а-яё]+\\s?$")) {
                    t_change = editText1.getText().toString();
                    proverka++;
                } else {
                    Toast toast = Toast.makeText(view.getContext(), str1[4] + "-incorect change", Toast.LENGTH_SHORT);
                    toast.show();
                }
                editText1 = (EditText) view.findViewById(R.id.t6);
                str1[5] = editText1.getText().toString();
                if (str1[5].length() > 0 && str1[5].matches("^(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))$")) {
                    t_icon = editText1.getText().toString();
                    proverka++;
                } else {
                    Toast toast = Toast.makeText(view.getContext(), str1[5] + "-incorect url", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (proverka == 6) {
                    try {
                        db = new DBConnectorAll(view.getContext());
                        int size = db.selectAllTable1().size();
                        if (size > 0) {
                            Toast.makeText(view.getContext(), "OK:....."+t_name+t_price+t_date+t_type+t_change+t_icon,
                                    Toast.LENGTH_SHORT).show();
                            db.Insert(new TableMenuDataClass(t_name, t_price, t_date, t_type, t_change, t_icon));
                            sinchronization++;
                            proverka = 0;
                        }
                    } catch (Exception e) {
                        Toast toast3 = Toast.makeText(view.getContext(), "Error writing to the database.", Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
            }
        });

        return view;
    }

}
