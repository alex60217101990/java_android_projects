package com.example.alex.myrestourant;

import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
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
 * Created by Alex on 28.10.2017.
 */

public class Fragment3 extends Fragment {
    DBConnectorAll db;
    ListAdapter elements_t1;
    ArrayList<TableMenuDataClass> table1 = new ArrayList<TableMenuDataClass>();
    private AnimationDrawable mAnimationDrawable;
    static long proverka=0;
    public static long sinchronization_table2;
    private String t_name;
    private long t_orders=-1;
    private long t_count=-1;
    private String t_change;
    private String t_foto;
    EditText editText1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.add_workers_table2, null);
        //logic of content...
        LinearLayout imageView = (LinearLayout) view.findViewById(R.id.workers_cont);
        imageView.setBackgroundResource(R.drawable.animation_list_2);

        mAnimationDrawable = (AnimationDrawable) imageView.getBackground();
        mAnimationDrawable.start();


        Button enter = (Button) view.findViewById(R.id.workers_button);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] str1 = new String[5];
                editText1 = (EditText) view.findViewById(R.id.workers_t1);
                str1[0] = editText1.getText().toString();
                if (str1[0].length() > 0 && str1[0].matches("^([А-ЯЁ][а-яё]+\\s?){3}$")) {
                    t_name = editText1.getText().toString();
                    proverka++;
                } else {
                    Toast toast = Toast.makeText(view.getContext(), str1[0] + "-incorect name", Toast.LENGTH_SHORT);
                    toast.show();
                }
                editText1 = (EditText) view.findViewById(R.id.workers_t2);
                str1[1] = editText1.getText().toString();
                if (str1[1].length() > 0 && str1[1].matches("^[0-9]{1,}\\s?$")) {
                    try {
                        t_orders = Long.valueOf(editText1.getText().toString());
                        proverka++;
                    } catch (Exception e) {
                        Toast toast = Toast.makeText(view.getContext(), str1[1] + "-incorect the number of orders",
                                Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(view.getContext(), str1[1] + "-incorect the number of orders",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
                editText1 = (EditText) view.findViewById(R.id.workers_t3);
                str1[2] = editText1.getText().toString();
                if (str1[2].length() > 0 && str1[2].matches("^[0-9]{1,}\\s?$")) {
                    try {
                        t_count = Long.valueOf(editText1.getText().toString());
                        proverka++;
                    } catch (Exception e) {
                        Toast toast = Toast.makeText(view.getContext(), str1[2] + "-incorect worked shifts",
                                Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(view.getContext(), str1[2] + "-incorect worked shifts",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
                editText1 = (EditText) view.findViewById(R.id.workers_t4);
                str1[3] = editText1.getText().toString();
                if (str1[3].length() > 0 && str1[3].matches("^[А-ЯЁ]?[а-яё]+\\s?$")) {
                    t_change = editText1.getText().toString();
                    proverka++;
                } else {
                    Toast toast = Toast.makeText(view.getContext(), str1[3] + "-incorect change", Toast.LENGTH_SHORT);
                    toast.show();
                }
                editText1 = (EditText) view.findViewById(R.id.workers_t5);
                str1[4] = editText1.getText().toString();
                if (str1[4].length() > 0 && str1[4].matches("^(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))$")) {
                    t_foto = editText1.getText().toString();
                    proverka++;
                } else {
                    Toast toast = Toast.makeText(view.getContext(), str1[4] + "-incorect url", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (proverka == 5) {
                    try {
                        db = new DBConnectorAll(view.getContext());
                        int size = db.selectAllTable2().size();
                        if (size >= 0) {
                            Toast.makeText(view.getContext(), "OK:****"+t_name+t_orders+t_count+t_change+t_foto,
                                    Toast.LENGTH_SHORT).show();
                            db.Insert(new TableWorkersDataClass(t_name, t_orders, t_count, t_change, t_foto));
                            sinchronization_table2++;
                            proverka = 0;
                        }
                    } catch (Exception e) {
                        Toast toast3 = Toast.makeText(view.getContext(), "Error writing to the database.(table 2)",
                                Toast.LENGTH_LONG);
                        toast3.show();
                    }
                }
                else{
                    if((!t_name.isEmpty())&&(t_orders!=-1)&&(t_count!=-1)&&(!t_change.isEmpty())&&(!t_foto.isEmpty())){
                        db.Insert(new TableWorkersDataClass(t_name, t_orders, t_count, t_change, t_foto));
                        sinchronization_table2++;
                        proverka = 0;
                    }
                    Toast.makeText(view.getContext(), "OK:****0000"+t_name+t_orders+t_count+t_change+t_foto,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
