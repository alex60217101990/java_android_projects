package com.example.alex.myrestourant;

/**
 * Created by Alex on 21.10.2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import static com.example.alex.myrestourant.MainActivity.CastomToast;

// Класс для создания БД #2
public class OpenHelperTable2 extends SQLiteOpenHelper implements AllTableInterface, ConstForDataBase {
    OpenHelperTable2(Context context) {
        super(context, DATA_BASE_NAME1, null, DATA_BASE_VERSION);
        CastomToast(context, "Data Base \"Worker's\" is active....",150);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE1_NAME + " (" +
                COLUMN_ID1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME1 + " TEXT, " +
                COLUMN_ORDERS + " LONG, " +
                COLUMN_DUR_OF_WORK + " LONG, " +
                COLUMN_CHANGE + " TEXT, "+
                COLUMN_FOTO + " TEXT); ";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        onCreate(db);
    }
}
