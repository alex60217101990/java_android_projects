package com.example.alex.myrestourant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Alex on 21.10.2017.
 */

// Класс для создания БД #1
public class OpenHelper extends SQLiteOpenHelper implements AllTableInterface, ConstForDataBase {
    OpenHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
        Toast toast = Toast.makeText(context, "111111", Toast.LENGTH_LONG);
        toast.show();
    }
    @Override
    synchronized  public void onCreate(SQLiteDatabase db) {
        try {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_PRICE + " REAL, " +
                    COLUMN_DATE + " LONG, " +
                    COLUMN_TYPE + " TEXT, " +
                    COLUMN_TIMES_OF_DAY + " TEXT, " +
                    COLUMN_ICON + " TEXT); ";
            db.execSQL(query);
        }catch (Exception e){
            close();
        }
    }
    @Override
    synchronized  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
