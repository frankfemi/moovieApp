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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.moovieApp.data.MoovieListContract;
import com.example.android.moovieApp.data.MoovielistDbHelper;
import com.example.android.moovieApp.data.film;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FilmActivity extends AppCompatActivity {
    private Button mBouttonEnregistrer;
    private EditText mNewFilmEditText;
    private EditText mNewDateEditText;
    private EditText mNewHeureEditText;
    private EditText mNewNoteScenarioEditText;
    private EditText mNewNoteRealisationEditText;
    private EditText mNewNoteMusiqueEditText;
    private EditText mNewDescriptionEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        mBouttonEnregistrer = (Button) findViewById(R.id.enregistrer_button);
        mBouttonEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mNewDateEditText = (EditText)  findViewById(R.id.date_film_edit_text);
                mNewFilmEditText = (EditText)  findViewById(R.id.titre_film_edit_text);
                mNewHeureEditText = (EditText)  findViewById(R.id.heure_film_edit_text);
                mNewNoteScenarioEditText = (EditText)  findViewById(R.id.note_scenario_edit_text);
                mNewNoteRealisationEditText = (EditText)  findViewById(R.id.note_rea_edit_text);
                mNewNoteMusiqueEditText = (EditText)  findViewById(R.id.note_musique_edit_text);
                mNewDescriptionEditText = (EditText)  findViewById(R.id.description_edit_text);

                film film = new film(mNewFilmEditText.getText().toString(),mNewDateEditText.getText().toString(),Integer.parseInt(mNewNoteScenarioEditText.getText().toString()),Integer.parseInt(mNewNoteRealisationEditText.getText().toString()),Integer.parseInt(mNewNoteMusiqueEditText.getText().toString()),mNewDescriptionEditText.getText().toString(),Integer.parseInt(mNewHeureEditText.getText().toString())  );

                Context context = FilmActivity.this;

                Class destinationActivity = MainActivity.class;

                Intent startChildActivityIntent = new Intent(context, destinationActivity);
                startChildActivityIntent.putExtra("donnee", (Serializable) film);
                startActivity(startChildActivityIntent);
            }
        });
    }


}