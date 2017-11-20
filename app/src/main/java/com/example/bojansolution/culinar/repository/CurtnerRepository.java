package com.example.bojansolution.culinar.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bojansolution.culinar.model.Curtner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bojan solution on 11/11/2017.
 */

public class CurtnerRepository {
    public static final String LOGTAG = "CURTNER_LOG";

    SQLiteOpenHelper dbHandler;
    SQLiteDatabase database;

    private static final String[] columns = {
            CurtnerDBHandler.COLUMN_ID,
            CurtnerDBHandler.COLUMN_NAME,
            CurtnerDBHandler.COLUMN_STATUS
    };

    public CurtnerRepository(Context context) {
        dbHandler = new CurtnerDBHandler(context);
    }

    public void open() {
        Log.i(LOGTAG, "Database opened");
        database = dbHandler.getWritableDatabase();
    }

    public void close() {
        Log.i(LOGTAG, "Database closed");
        dbHandler.close();
    }

    public Curtner addCurtner(Curtner curtner) {
        ContentValues values = new ContentValues();
//        values.put(CurtnerDBHandler.COLUMN_ID, curtner.getId());
        values.put(CurtnerDBHandler.COLUMN_NAME, curtner.getName());
        values.put(CurtnerDBHandler.COLUMN_STATUS, curtner.getStatus());
        long id = database.insert(CurtnerDBHandler.TABLE_NAME, null, values);
        curtner.setId((int)id);
        return curtner;
    }

    public Curtner getCurtner(int id) {
        Cursor cursor = database.query(CurtnerDBHandler.TABLE_NAME, columns, CurtnerDBHandler.COLUMN_ID + "=?"
                , new String[] {String.valueOf(id)}, null, null, null, null);
        if(null != cursor) {
            cursor.moveToFirst();
        }
        Curtner curtner = new Curtner(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
        return curtner;
    }

    public List<Curtner> getAllCurtner() {
        Cursor cursor = database.query(CurtnerDBHandler.TABLE_NAME, columns, null, null, null, null, null);
        List<Curtner> curtners = new ArrayList<>();
        if(cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                Curtner curtner = new Curtner();
                curtner.setId(cursor.getInt(0));
                curtner.setName(cursor.getString(1));
                curtner.setStatus(cursor.getInt(2));
                curtners.add(curtner);
            }
        }
        return curtners;
    }

    public int updateCurtner(Curtner curtner) {
        ContentValues values = new ContentValues();
        values.put(CurtnerDBHandler.COLUMN_NAME, curtner.getName());
        values.put(CurtnerDBHandler.COLUMN_STATUS, curtner.getStatus());
        return database.update(CurtnerDBHandler.TABLE_NAME, values
                , CurtnerDBHandler.COLUMN_ID + "=?", new String[]{String.valueOf(curtner.getId())});
    }

    public int deleteCurtner(Curtner curtner) {
        return database.delete(CurtnerDBHandler.TABLE_NAME
                , CurtnerDBHandler.COLUMN_ID + "=" + curtner.getId(), null);
    }
}
