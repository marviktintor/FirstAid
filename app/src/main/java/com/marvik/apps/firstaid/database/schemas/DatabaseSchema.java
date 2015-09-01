package com.marvik.apps.firstaid.database.schemas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.marvik.apps.firstaid.database.tables.Tables;

/**
 * Created by victor on 9/1/2015.
 */
public class DatabaseSchema extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FirstAids";
    private static final int DATABASE_VERSION = 1;

    public DatabaseSchema(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tables.Attacks.SQL);
        db.execSQL(Tables.Symptoms.SQL);
        db.execSQL(Tables.FirstAids.SQL);
        db.execSQL(Tables.Notes.SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
