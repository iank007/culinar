package com.example.bojansolution.culinar.repository;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bojan solution on 11/11/2017.
 */

public class CurtnerDBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME  = "curtner.db";
    private static final int DATABASE_VERSION  = 1;

    public static final String TABLE_NAME      = "curtner";
    public static final String COLUMN_ID       = "id";
    public static final String COLUMN_NAME     = "name";
    public static final String COLUMN_STATUS   = "status";

    private static final String QUERY_CREATE = "CREATE TABLE " + TABLE_NAME + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTO_INCREMENT," +
            COLUMN_NAME + " TEXT," +
            COLUMN_STATUS + " INTEGER)";

    public CurtnerDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUERY_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        sqLiteDatabase.execSQL(QUERY_CREATE);
    }
}
