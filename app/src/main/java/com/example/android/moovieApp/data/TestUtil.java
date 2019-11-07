package com.example.android.moovieApp.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static void insertFakeData(SQLiteDatabase db){
        if(db == null){
            return;
        }
        //create a list of fake guests
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_TITRE_FILM, "Film1");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DATE_FILM, "07/11/2019");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_HEURE_FILM, "12");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_SCENARIO, 10);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_REALISATION, 11);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_MUSIQUE, 13);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DESCRIPTION, "raf");
        list.add(cv);

        cv = new ContentValues();
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_TITRE_FILM, "Film2");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DATE_FILM, "07/11/2019");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_HEURE_FILM, "12");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_SCENARIO, 14);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_REALISATION, 11);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_MUSIQUE, 17);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DESCRIPTION, "raf");
        list.add(cv);

        cv = new ContentValues();
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_TITRE_FILM, "Film3");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DATE_FILM, "07/11/2019");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_HEURE_FILM, "12");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_SCENARIO, 10);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_REALISATION, 11);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_MUSIQUE, 13);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DESCRIPTION, "raf");
        list.add(cv);

        cv = new ContentValues();
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_TITRE_FILM, "Film4");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DATE_FILM, "07/11/2019");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_HEURE_FILM, "12");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_SCENARIO, 10);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_REALISATION, 11);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_MUSIQUE, 13);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DESCRIPTION, "raf");
        list.add(cv);

        cv = new ContentValues();
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_TITRE_FILM, "Film5");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DATE_FILM, "07/11/2019");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_HEURE_FILM, "12");
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_SCENARIO, 10);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_REALISATION, 11);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_MUSIQUE, 13);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DESCRIPTION, "raf");
        list.add(cv);

        //insert all guests in one transaction
        try
        {
            db.beginTransaction();
            //clear the table first
            db.delete (MoovieListContract.MoovielistEntry.TABLE_NAME,null,null);
            //go through the list and add one by one
            for(ContentValues c:list){
                db.insert(MoovieListContract.MoovielistEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            //too bad :(
        }
        finally
        {
            db.endTransaction();
        }

    }
}