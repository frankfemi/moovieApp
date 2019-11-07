package com.example.android.moovieApp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.android.moovieApp.data.film;

import com.example.android.moovieApp.data.MoovieListContract;
import com.example.android.moovieApp.data.MoovielistDbHelper;
import com.example.android.moovieApp.data.TestUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private FilmListAdapter mAdapter;
    private SQLiteDatabase mDb;
    private Button mBoutton;

    private final static String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBoutton = (Button) findViewById(R.id.ajouter_film_button);

        mBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;

                Class destinationActivity = FilmActivity.class;
                Intent startChildActivityIntent = new Intent(context, destinationActivity);

                startActivity(startChildActivityIntent);
            }
        });

        RecyclerView filmlistRecyclerView;

        // Set local attributes to corresponding views
        filmlistRecyclerView = (RecyclerView) this.findViewById(R.id.all_film_list_view);

        // Set layout for the RecyclerView, because it's a list we are using the linear layout
        filmlistRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Create a DB helper (this will create the DB if run for the first time)
        MoovielistDbHelper dbHelper = new MoovielistDbHelper(this);

        // Keep a reference to the mDb until paused or killed. Get a writable database
        // because you will be adding restaurant customers
        mDb = dbHelper.getWritableDatabase();

        // Get all guest info from the database and save in a cursor
        Cursor cursor = getAllFilms();

        // Create an adapter for that cursor to display the data
        mAdapter = new FilmListAdapter(this, cursor);

        // Link the adapter to the RecyclerView
        filmlistRecyclerView.setAdapter(mAdapter);

    }


    @Override
    protected void onResume() {
        super.onResume();
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            film film = (com.example.android.moovieApp.data.film) intentThatStartedThisActivity.getSerializableExtra("MyClass");

            addNewFilm(film.getTitreFilm(),film.getDate(),film.getHeure(),film.getNotescenario(), film.getNotemusique(),film.getNoterealisation(),film.getDescription() );

            // COMPLETED (19) call mAdapter.swapCursor to update the cursor by passing in getAllGuests()
            // Update the cursor in the adapter to trigger UI to display the new list
            mAdapter.swapCursor(getAllFilms());
        }

    }

    /**
     * @return Cursor containing the list of guests
     */
    private Cursor getAllFilms() {
        return mDb.query(
                MoovieListContract.MoovielistEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                MoovieListContract.MoovielistEntry.COLUMN_TITRE_FILM
        );
    }

    // COMPLETED (4) Create a new addNewGuest method
    /**
     * Adds a new guest to the mDb including the party count and the current timestamp
     *
     * @param titre  Film's name
     * @param date Date
     * @param heure
     * @param note_scenario
     * @param note_musique
     * @param note_realisation
     * @param description
     * @return id of new record added
     */
    private long addNewFilm(String titre, String date, int heure, int note_scenario, int note_musique, int note_realisation, String description) {

        ContentValues cv = new ContentValues();
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_TITRE_FILM, titre);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DATE_FILM, date.toString());
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_HEURE_FILM, heure);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_MUSIQUE, note_musique);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_REALISATION, note_realisation);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_NOTE_SCENARIO, note_scenario);
        cv.put(MoovieListContract.MoovielistEntry.COLUMN_DESCRIPTION, description);

        return mDb.insert(MoovieListContract.MoovielistEntry.TABLE_NAME, null, cv);
    }

}