package com.example.android.moovieApp.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.moovieApp.data.MoovieListContract.*;

public class MoovielistDbHelper extends SQLiteOpenHelper {

    // The database name
    private static final String DATABASE_NAME = "moovielist.db";


    private static final int DATABASE_VERSION = 2;

    // Constructor
    public MoovielistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Create a table to hold moovielist data
        final String SQL_CREATE_MOOVIELIST_TABLE = "CREATE TABLE " + MoovielistEntry.TABLE_NAME + " (" +
                MoovielistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MoovielistEntry.COLUMN_TITRE_FILM + " TEXT NOT NULL, " +
                MoovielistEntry.COLUMN_DATE_FILM + " TEXT NOT NULL, " +
                MoovielistEntry.COLUMN_HEURE_FILM + " TEXT NOT NULL, " +
                MoovielistEntry.COLUMN_NOTE_SCENARIO + " INTTEGER NOT NULL, " +
                MoovielistEntry.COLUMN_NOTE_REALISATION + " INTTEGER NOT NULL, " +
                MoovielistEntry.COLUMN_NOTE_MUSIQUE + " INTTEGER NOT NULL, " +
                MoovielistEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL" +

                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_MOOVIELIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // For now simply drop the table and create a new one. This means if you change the
        // DATABASE_VERSION the table will be dropped.
        // In a production app, this method might be modified to ALTER the table
        // instead of dropping it, so that existing data is not deleted.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MoovielistEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}