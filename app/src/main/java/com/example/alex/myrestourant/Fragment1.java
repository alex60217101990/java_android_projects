package com.example.alex.myrestourant;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.ViewUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static android.R.id.tabhost;
import static com.example.alex.myrestourant.Fragment2.sinchronization;
import static com.example.alex.myrestourant.Fragment3.sinchronization_table2;
import static com.example.alex.myrestourant.MainActivity.allSize;
import static com.example.alex.myrestourant.MainActivity.counter;
import static com.example.alex.myrestourant.MainActivity.table1_static;
import static com.example.alex.myrestourant.MainActivity.table2_static;
import static com.example.alex.myrestourant.MainActivity.time_price;

/**
 * Created by Alex on 25.10.2017.
 */

public class Fragment1 extends Fragment {
    TabHost.TabSpec tabSpec;
    DBConnectorAll db;
    ListAdapter elements_t1;
    ListAdapterForTable2 elements_t2;
    ProgressBar progressBar;
    ArrayList<TableMenuDataClass> table1 = new ArrayList<TableMenuDataClass>();
    ArrayList<TableWorkersDataClass> table2 = new ArrayList<TableWorkersDataClass>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_new_element, null);
        DBwork Task = new DBwork(view);
        Task.execute();
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
       // progressBar.setVisibility(View.VISIBLE);
        progressBar.setAlpha(1);
        //распределяем таблицы базы данных по вкладкам
        TabHost tabHost = (TabHost) view.findViewById(tabhost);
        // инициализация
        tabHost.setup();
        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("Таблица \"Меню\":");

        tabSpec.setContent(R.id.gridview);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("Таблица \"Сотрудники\" 2");
        tabSpec.setContent(R.id.gridview1);
        tabHost.addTab(tabSpec);
        // 1 вкладка по умолчанию активна
        tabHost.setCurrentTabByTag("tag1");
        //распределяем таблицы базы данных по вкладкам


     /*   db = new DBConnectorAll(view.getContext());
        if (counter == 1) {
            long a1 = db.DeleteAll(1);
            db.DeleteAll(2);
            fillData(db);
            table2 = db.selectAllTable2();
            table1 = db.selectAllTable1();

            table1_static = table1;
            table2_static = table2;
        } else {
            if (sinchronization > 0 || sinchronization_table2 > 0) {
                table2 = db.selectAllTable2();
                table1 = db.selectAllTable1();
                Toast toast = Toast.makeText(view.getContext(), "sinchr", Toast.LENGTH_SHORT);
                toast.show();
                sinchronization = 0;
                sinchronization_table2 = 0;
                table1_static = table1;
                table2_static = table2;
            } else {
                table1 = table1_static;
                table2 = table2_static;
            }
        }
        counter++;*/

    /*    // получаем элемент ListView
        //    ListView countriesList = (ListView) findViewById(R.id.countriesList);
        GridView countriesList = (GridView) view.findViewById(R.id.gridview);
        GridView countriesList1 = (GridView) view.findViewById(R.id.gridview1);
        // создаем адаптер
        elements_t1 = new ListAdapter(view.getContext(), R.layout.item_of_table_1, table1);
        // создаем адаптер 2
        elements_t2 = new ListAdapterForTable2(view.getContext(), R.layout.item_of_table_2, table2);

        /// устанавливаем адаптер's
        countriesList.setAdapter(elements_t1);
        countriesList1.setAdapter(elements_t2);*/

        /*oтслеживаем какие пункты из таблицы меню были выбраны.*/
      /*  countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // DO something
                //String time=db.SelectTable1().getName();
                time_price += table1.get(position).getPrice();
                Toast toast = Toast.makeText(v.getContext(), "" + time_price, Toast.LENGTH_LONG);
                toast.show();

            }
        });
        /*тслеживаем какие пункты из таблицы сотрудников были выбраны.*/
     /*   countriesList1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // DO something
                Toast toast = Toast.makeText(v.getContext(), position + "-" + id, Toast.LENGTH_LONG);
                toast.show();

            }
        });*/
     runAsynchronouslyMethod();
        return view;
    }

    // генерируем данные для адаптера
    void fillData(DBConnectorAll db1) {
        for (int i = 1; i <= 10; i++) {

            //        table2.add(new TableWorkersDataClass(i, "name " + i, i, i, "type",
            //               "https://dayonline.ru/public/wysiwyg/images/11(6).jpg"));
            db.Insert(new TableWorkersDataClass("Ivanov Ivan Ivanovich " + i, i, i, "type",
                    "https://dayonline.ru/public/wysiwyg/images/11(6).jpg"));
            db.Insert(new TableMenuDataClass(/*i,*/ "name " + i, i, i, "type", "day",
                    "https://itc.ua/wp-content/uploads/2015/10/0qmm-dYUnrhKWsgmClbLEvBSfpfJUngkZtPxgiqMiNw-671x362.jpg"));
        }
    }

    /*neobyazatelniy metod*/
    void runAsynchronouslyMethod() {
       Timer t= new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 2 seconds
                try{
              //  progressBar.setVisibility(View.INVISIBLE);
                    if(progressBar.getAlpha()==1){
                        progressBar.setAlpha(0);
                    }
                }
                catch (Exception e){
                   return;
                }
            }
        }, 2000);
    }
    /*neobyazatelniy metod*/

    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    class DBwork extends AsyncTask<Void, Void, Boolean> {
        View v;


        // DBConnectorAll db;
        public DBwork(View gview) {
            this.v = gview;
            progressBar=(ProgressBar) v.findViewById(R.id.progressBar);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast toast1 = Toast.makeText(v.getContext(), "Start uploading data.", Toast.LENGTH_SHORT);
            toast1.show();
            db = new DBConnectorAll(v.getContext());

        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try{

                if (counter == 1||counter==0) {
                    if(allSize==0) {
                        long a1 = db.DeleteAll(1);
                        db.DeleteAll(2);
                        fillData(db);
                    }
                    table2 = db.selectAllTable2();
                    table1 = db.selectAllTable1();
                    allSize++;
                    table1_static = table1;
                    table2_static = table2;
                } else {
                    if (sinchronization > 0 || sinchronization_table2 > 0) {
                        table2 = db.selectAllTable2();
                        table1 = db.selectAllTable1();

                        sinchronization = 0;
                        sinchronization_table2 = 0;
                        table1_static = table1;
                        table2_static = table2;
                    } else {
                        table1 = table1_static;
                        table2 = table2_static;
                    }
                }
                counter++;
                if(table1.size()>0 && table2.size()>0)return true;
                else return false;
            }catch (Exception e){
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            try {
                if(result==true){
                    Toast toast1 = Toast.makeText(v.getContext(), "Stop uploading data.", Toast.LENGTH_SHORT);
                    toast1.show();

                    // получаем элемент ListView
                    //    ListView countriesList = (ListView) findViewById(R.id.countriesList);
                    GridView countriesList = (GridView) v.findViewById(R.id.gridview);
                    GridView countriesList1 = (GridView) v.findViewById(R.id.gridview1);
                    // создаем адаптер
                    elements_t1 = new ListAdapter(v.getContext(), R.layout.item_of_table_1, table1);
                    // создаем адаптер 2
                    elements_t2 = new ListAdapterForTable2(v.getContext(), R.layout.item_of_table_2, table2);

                    /// устанавливаем адаптер's
                    countriesList.setAdapter(elements_t1);
                    countriesList1.setAdapter(elements_t2);


                    /*oтслеживаем какие пункты из таблицы меню были выбраны.*/
                    countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                                // DO something
                            //String time=db.SelectTable1().getName();
                            time_price += table1.get(position).getPrice();
                            Toast toast = Toast.makeText(v.getContext(), "" + time_price, Toast.LENGTH_LONG);
                            toast.show();

                        }
                    });
                    /*тслеживаем какие пункты из таблицы сотрудников были выбраны.*/
                    countriesList1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                                // DO something
                            Toast toast = Toast.makeText(v.getContext(), position + "-" + id, Toast.LENGTH_LONG);
                            toast.show();

                        }
                    });

                }else{
                    Toast toast1 = Toast.makeText(v.getContext(), "A read error occurred.", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }catch (Exception e){
                Toast toast1 = Toast.makeText(v.getContext(), "A read error occurred.", Toast.LENGTH_SHORT);
                toast1.show();
                progressBar.setVisibility(v.INVISIBLE);
            }
        }
    }
}
