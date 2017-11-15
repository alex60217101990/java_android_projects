package com.example.alex.myrestourant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Handler;
import android.view.Display;
import android.widget.Toast;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.alex.myrestourant.MainActivity.CastomToast;

/**
 * Created by Alex on 21.10.2017.
 */

// Класс для создания БД #1
public class OpenHelper extends SQLiteOpenHelper implements AllTableInterface, ConstForDataBase {
    OpenHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
   CastomToast(context, "Data Base \"Menu\" is active....",100);
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
        }
    }
    @Override
    synchronized  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
