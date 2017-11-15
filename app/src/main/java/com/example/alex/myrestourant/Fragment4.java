package com.example.alex.myrestourant;

import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static com.example.alex.myrestourant.Fragment2.sinchronization;
import static com.example.alex.myrestourant.MainActivity.table1_static;
import static com.example.alex.myrestourant.MainActivity.table2_static;


/**
 * Created by Alex on 29.10.2017.
 */

public class Fragment4 extends Fragment {
    private AnimationDrawable mAnimationDrawable;
    private Integer position_right=-1;
    private Integer position_left=-1;
    static Integer counter_del_all_base1=0;
    static Integer counter_del_all_base2=0;
    private ArrayList<String>Data;
    private ArrayList<String>Data1;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter;
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
        Data=new ArrayList<String>();
        Data.add("menu elements:");
        for (TableMenuDataClass a:table1_static){
            Data.add(a.getName());
        }
        // адаптер 2
        Data1=new ArrayList<String>();
        Data1.add("worker's:");
        for (TableWorkersDataClass a:table2_static){
            Data1.add(a.getName().split("[А-Я][а-я]+?")[0]);
        }


        adapter1 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, Data1);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner2);
        spinner1.setAdapter(adapter1);
        // заголовок
        spinner1.setPrompt("Menu worker's for delete");
        // выделяем элемент
      //  spinner1.setSelection(1);
        /*--------------------------------------------------------------------------------------------------------------*/
        // устанавливаем обработчик нажатия
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       final int position, long id) {
                // показываем позиция нажатого элемента
            //    Toast.makeText(view.getContext(), "Position = " + position, Toast.LENGTH_SHORT).show();

                try{
                    position_left=position;
                    Task1 task=new Task1(view);
                    task.execute();

                }catch (Exception e){
              //      Toast.makeText(view.getContext(), "delete error", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

/*--------------------------------------------------------------------------------------------------------------------------*/

      //  Toast.makeText(view.getContext(), ""+data.length, Toast.LENGTH_SHORT).show();
        adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, Data);
        adapter.setDropDownViewResource(/*android.R.layout.simple_spinner_dropdown_item*/R.layout.spinner_dropdown_item);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Menu elements for delete");
        // выделяем элемент по-умолчанию:
    //    spinner.setSelection(2);
        /*-----------------------------------------------------------------------------------------------------------------*/
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
             //   Toast.makeText(view.getContext(), "Position = " + position, Toast.LENGTH_SHORT).show();

                try{
                    position_right=position;
                    Task1 task=new Task1(view);
                    task.execute();

                }catch (Exception e){
                    //      Toast.makeText(view.getContext(), "delete error", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

/*------------------------------------------------------------------------------------------------------------------------*/


        final Animation animAlpha = AnimationUtils.loadAnimation(view.getContext(), R.anim.alpha);
        at.markushi.ui.CircleButton btnAlpha = (at.markushi.ui.CircleButton)view.findViewById(R.id.alpha1);
        btnAlpha.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha);
                //dosomthink;
                counter_del_all_base1++;
                Task2 t=new Task2(view);
                t.execute();
            }
        });

        at.markushi.ui.CircleButton btnAlpha1 = (at.markushi.ui.CircleButton)view.findViewById(R.id.alpha2);
        btnAlpha1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha);
                //dosomthink;
                counter_del_all_base2++;
               Task2 t=new Task2(view);
                t.execute();
            }
        });

        return view;
    }



    class Task1 extends AsyncTask<Void, Integer, Boolean> {
        View view;
        private DBConnectorAll db;
        public Task1(View gview) {
            this.view = gview;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            db=new DBConnectorAll(view.getContext());
        }

        @Override
        protected Boolean doInBackground(Void... position) {
            try {
                if(position_right!=0) {
                    db.DeleteById(Data.get(position_right), 1);
                    Data.remove(position_right);
                }else
                if(position_left!=0) {
                    db.DeleteById(Data1.get(position_left), 2);
                    Data1.remove(position_left);
                }
                sinchronization++;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            if(result==true){
              //  Toast.makeText(view.getContext(), "delete1", Toast.LENGTH_SHORT).show();
                adapter1 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, Data1);
                adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, Data);
            }else{
              //  Toast.makeText(view.getContext(), "delete1 error", Toast.LENGTH_SHORT).show();
            }
        }
    }




    class Task2 extends AsyncTask<Void, Integer, Boolean> {
        View view;
        private DBConnectorAll db;
        private ArrayList<TableMenuDataClass> table1 = new ArrayList<>();
        private ArrayList<TableWorkersDataClass>table2=new ArrayList<>();
        public Task2(View gview) {
            this.view = gview;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            db=new DBConnectorAll(view.getContext());
        }

        @Override
        protected Boolean doInBackground(Void... position) {
            try {
                if(counter_del_all_base1>0){
                    table1_static.clear();
                    table2_static=db.selectAllTable2();
                    Data.clear();
                    db.DeleteAll(1);
                }
                if(counter_del_all_base2>0){
                    table2_static.clear();
                    table1_static=db.selectAllTable1();
                    Data1.clear();
                    db.DeleteAll(2);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            if(result==true){
                //  Toast.makeText(view.getContext(), "delete1", Toast.LENGTH_SHORT).show();
                adapter1 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, Data1);
                adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item, Data);
            }else{
                //  Toast.makeText(view.getContext(), "delete1 error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
