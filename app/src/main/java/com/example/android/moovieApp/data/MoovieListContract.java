package com.example.android.moovieApp.data;

import android.provider.BaseColumns;


public class MoovieListContract {

    public static final class MoovielistEntry implements BaseColumns {
        public static final String TABLE_NAME = "moovielist";
        public static final String COLUMN_TITRE_FILM = "titreFilm";
        public static final String COLUMN_DATE_FILM = "dateFilm";
        public static final String COLUMN_HEURE_FILM = "heureFilm";
        public static final String COLUMN_NOTE_SCENARIO = "noteScenario";
        public static final String COLUMN_NOTE_REALISATION = "noteRealisation";
        public static final String COLUMN_NOTE_MUSIQUE = "noteMusique";
        public static final String COLUMN_DESCRIPTION = "description";
    }

}
