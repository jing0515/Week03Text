package com.bawei.lvwenjing.week03text.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bawei.lvwenjing.week03text.Bean;
import com.bawei.lvwenjing.week03text.Beans;
import com.bawei.lvwenjing.week03text.SqlHelp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo-pc on 2017/5/21.
 */

public class SqlDao {
    Context context;
    private final SQLiteDatabase dp;

    public SqlDao(Context context) {
        SqlHelp sqlHelp = new SqlHelp(context);
        dp = sqlHelp.getWritableDatabase();
    }

    public boolean insert(String title, String phone) {
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("phone", phone);
        long text = dp.insert("text", null, values);
        if (text != -1) {
            return true;
        } else {
            return false;
        }

    }

    public List<Beans> select() {
        List<Beans> list = new ArrayList<Beans>();
        Cursor cursor = dp.query("text", null, null, null, null, null, null,
                null);
        while (cursor.moveToNext()) {
            String phone = cursor.getString(cursor.getColumnIndex("title"));
            String emali = cursor.getString(cursor.getColumnIndex("phone"));
            list.add(new Beans(emali, phone));
        }
        return list;
    }


}
