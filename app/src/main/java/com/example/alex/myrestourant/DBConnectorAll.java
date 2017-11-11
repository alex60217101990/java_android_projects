package com.example.alex.myrestourant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Alex on 25.10.2017.
 */

public class DBConnectorAll implements WorkWithDBInterface, ConstForDataBase{
    private SQLiteDatabase mDataBase, mDataBase1;
    private Context cont;
    private String time;
    public DBConnectorAll(Context context){
        // открываем (или создаем и открываем) БД для записи и чтения
        OpenHelper mOpenHelper = new OpenHelper(context);
        OpenHelperTable2 mOpenHelper1= new OpenHelperTable2(context);
        mDataBase = mOpenHelper.getWritableDatabase();
        mDataBase1= mOpenHelper1.getWritableDatabase();
        cont=context;
    }
    // Метод добавления строки в БД
    public long Insert(TableWorkersDataClass model2) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME1, model2.getName());
        cv.put(COLUMN_ORDERS, model2.getOrders());
        cv.put(COLUMN_DUR_OF_WORK, model2.getDuration_of_work());
        cv.put(COLUMN_CHANGE, model2.getChange_worker());
        cv.put(COLUMN_FOTO, model2.getFoto());
        return mDataBase1.insert(TABLE1_NAME, null, cv);
    }
    public long Insert(TableMenuDataClass model1) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME, model1.getName());
        cv.put(COLUMN_PRICE, model1.getPrice());
        cv.put(COLUMN_DATE, model1.getDate());
        cv.put(COLUMN_TYPE, model1.getTime_type());
        cv.put(COLUMN_TIMES_OF_DAY, model1.getChange());
        cv.put(COLUMN_ICON,model1.getIcon());
        return mDataBase.insert(TABLE_NAME, null, cv);
    }


    public int Update(TableWorkersDataClass model1, long id) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME1, model1.getName());
        cv.put(COLUMN_ORDERS, model1.getOrders());
        cv.put(COLUMN_DUR_OF_WORK, model1.getDuration_of_work());
        cv.put(COLUMN_CHANGE, model1.getChange_worker());
        cv.put(COLUMN_FOTO, model1.getFoto());
        return mDataBase1.update(TABLE1_NAME, cv, COLUMN_ID1 + " = ?", new String[] {String.valueOf(id) });
    }
    public int Update(TableMenuDataClass model1, long id) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME1, model1.getName());
        cv.put(COLUMN_PRICE, model1.getPrice());
        cv.put(COLUMN_DATE, model1.getDate());
        cv.put(COLUMN_TYPE, model1.getTime_type());
        cv.put(COLUMN_TIMES_OF_DAY, model1.getChange());
        cv.put(COLUMN_ICON,model1.getIcon());
        return mDataBase.update(TABLE_NAME, cv, COLUMN_ID + " = ?", new String[] {String.valueOf(/*model1.getId()*/id) });
    }

    public int DeleteAll(int identificator) {
        if (identificator==2) {  return mDataBase1.delete(TABLE1_NAME, null, null); }
        else{ return mDataBase.delete(TABLE_NAME, null, null); }
    }

    /*public void DeleteById(long id, int identificator){
        if(identificator==2)
                mDataBase1.delete(TABLE1_NAME, COLUMN_ID1 + " = ?", new String[] { String.valueOf(id) });
        else
                mDataBase.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
    }*/

    public void DeleteById(String name, int identificator){
        if(identificator==2)
            mDataBase1.delete(TABLE1_NAME, COLUMN_NAME1 + " = ?", new String[] { name });
        else
            mDataBase.delete(TABLE_NAME, COLUMN_NAME + " = ?", new String[] { name });
    }
    public TableWorkersDataClass SelectTable2(long id){
                Cursor mCursor = mDataBase1.query(TABLE1_NAME, null, COLUMN_ID1 + " = ?",
                        new String[] {String.valueOf(id)}, null, null, COLUMN_NAME1);
                mCursor.moveToFirst();

                String name = mCursor.getString(NUM_COLUMN_NAME1);
                long orders=mCursor.getLong(NUM_COLUMN_ORDERS);
                long durOfWork=mCursor.getLong(NUM_COLUMN_DUR_OF_WORK);
                String change=mCursor.getString(NUM_CHANGE);
                String foto=mCursor.getString(NUM_FOTO);

                mCursor.close();
                return new TableWorkersDataClass(name, orders, durOfWork, change, foto);
            }
    public TableMenuDataClass SelectTable1(long id){
                Cursor mCursor = mDataBase.query(TABLE_NAME, null, COLUMN_ID + " = ?",
                        new String[] {String.valueOf(id)}, null, null, COLUMN_NAME);
                mCursor.moveToFirst();

                String name = mCursor.getString(NUM_COLUMN_NAME);
                double price=mCursor.getDouble(NUM_COLUMN_PRICE);
                long date=mCursor.getLong(NUM_COLUMN_DATE);
                String timeTipe=mCursor.getString(NUM_COLUMN_TYPE);
                String timeOfDay=mCursor.getString(NUM_COLUMN_TIME);
                String icon=mCursor.getString(NUM_COLUMN_ICON);

                mCursor.close();
                return new TableMenuDataClass(/*id,*/ name, price, date, timeTipe, timeOfDay, icon);
    }

    public ArrayList<TableMenuDataClass> selectAllTable1(){
            Cursor mCursor = mDataBase.query(TABLE_NAME, null, null, null, null, null, COLUMN_NAME);
            ArrayList<TableMenuDataClass> arr = new ArrayList<TableMenuDataClass>();
                mCursor.moveToFirst();
        try {
            if (!mCursor.isAfterLast()) {
                do {
                    long id = mCursor.getLong(NUM_ID);
                    String name = mCursor.getString(NUM_COLUMN_NAME);
                    double price = mCursor.getDouble(NUM_COLUMN_PRICE);
                    long date = mCursor.getLong(NUM_COLUMN_DATE);
                    String timeType = mCursor.getString(NUM_COLUMN_TYPE);
                    String timeOfDay = mCursor.getString(NUM_COLUMN_TIME);
                    //   time=timeType;
                    String icon = mCursor.getString(NUM_COLUMN_ICON);
                    arr.add(new TableMenuDataClass(/*id,*/ name, price, date, timeType, timeOfDay, icon));
                } while (mCursor.moveToNext());
            }
            mCursor.close();
        }catch (Exception e){
            Toast toast = Toast.makeText(cont, "have not table", Toast.LENGTH_LONG);
            toast.show();
        }
            return arr;
        }
    public ArrayList<TableWorkersDataClass> selectAllTable2(){
            Cursor mCursor = mDataBase1.query(TABLE1_NAME, null, null, null, null, null, COLUMN_NAME1);

            ArrayList<TableWorkersDataClass> arr = new ArrayList<TableWorkersDataClass>();
            mCursor.moveToFirst();

            if (!mCursor.isAfterLast()) {
                do {
                    long id = mCursor.getLong(NUM_ID1);
                    String name = mCursor.getString(NUM_COLUMN_NAME1);
                    long orders = mCursor.getLong(NUM_COLUMN_ORDERS);
                    long dur_of_work = mCursor.getLong(NUM_COLUMN_DUR_OF_WORK);
                    String change = mCursor.getString(NUM_CHANGE);
                    String foto = mCursor.getString(NUM_FOTO);

                    arr.add(new TableWorkersDataClass(name, orders, dur_of_work, change, foto));
                } while (mCursor.moveToNext());
            }
            mCursor.close();
            return arr;
        }
}
