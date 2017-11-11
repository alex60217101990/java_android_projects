package com.example.alex.myrestourant;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by Alex on 21.10.2017.
 */

public interface AllTableInterface {
    public void onCreate(SQLiteDatabase db);
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
}
