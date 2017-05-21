package com.bawei.lvwenjing.week03text;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo-pc on 2017/5/21.
 */

public class SqlHelp extends SQLiteOpenHelper {
    public SqlHelp(Context context) {
        super(context, "text.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //	db.execSQL("create table texts (id integer primary key autoincrement,name varchar(20),money varchar(20))");
        db.execSQL("create table text (id integer primary key autoincrement ,title varchar(200),phone varchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
