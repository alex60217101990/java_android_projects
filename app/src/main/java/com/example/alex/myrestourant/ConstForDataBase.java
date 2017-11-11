package com.example.alex.myrestourant;

/**
 * Created by Alex on 21.10.2017.
 */

public interface ConstForDataBase {
    final String DATA_BASE_NAME="RESTOURANT_Db";
    final String DATA_BASE_NAME1="RESTOURANT_DB1";
    final int DATA_BASE_VERSION=2;
    final static String TABLE_NAME = "TableMenu1";
    final static String TABLE1_NAME = "TableMenage";

    // Название столбцов t.1
    final static String COLUMN_ID="_id";
    final static String COLUMN_NAME="_NAME";
    final static String COLUMN_PRICE="_PRICE";
    final static String COLUMN_DATE="_DATE";
    final static String COLUMN_TYPE="_TYPE";
    final static String COLUMN_TIMES_OF_DAY="_DAY_TIME";
    final static String COLUMN_ICON="_ICON";
    // Номера столбцов t.1
    final static int NUM_ID=0;
    final static int NUM_COLUMN_NAME=1;
    final static int NUM_COLUMN_PRICE=2;
    final static int NUM_COLUMN_DATE=3;
    final static int NUM_COLUMN_TYPE=4;
    final static int NUM_COLUMN_TIME=5;
    final static int NUM_COLUMN_ICON=6;

    // Название столбцов t.2
    final static String COLUMN_ID1="_id";
    final static String COLUMN_NAME1="_NAME_WORKER";
    final static String COLUMN_ORDERS="_COUNT_ORDERS";
    final static String COLUMN_DUR_OF_WORK="_DURATION_OF_WORK";
    final static String COLUMN_CHANGE="_CHANGE_WORKER";
    final static String COLUMN_FOTO="_FOTO";

    // Номера столбцов t.2
    final static int NUM_ID1=0;
    final static int NUM_COLUMN_NAME1=1;
    final static int NUM_COLUMN_ORDERS=2;
    final static int NUM_COLUMN_DUR_OF_WORK=3;
    final static int NUM_CHANGE=4;
    final static int NUM_FOTO=5;
}
