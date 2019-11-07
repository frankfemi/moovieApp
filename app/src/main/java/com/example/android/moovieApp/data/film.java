package com.example.android.moovieApp.data;

import java.io.Serializable;

public class film implements Serializable {
    private String titreFilm;
    private String date;
    private int notescenario;
    private int noterealisation;
    private int notemusique;
    private String description;
    private int heure;

    public film(String titre, String date, int noteSceanrio, int noteMusique, int noteRealisation, String descr, int heure){
        this.titreFilm = titre;
        this.date = date;
        this.notemusique = noteMusique;
        this.noterealisation = noteRealisation;
        this.notescenario = noteSceanrio;
        this.description = descr;
        this.heure = heure;
    }

    public String getTitreFilm() {
        return titreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNotescenario() {
        return notescenario;
    }

    public void setNotescenario(int notescenario) {
        this.notescenario = notescenario;
    }

    public int getNoterealisation() {
        return noterealisation;
    }

    public void setNoterealisation(int noterealisation) {
        this.noterealisation = noterealisation;
    }

    public int getNotemusique() {
        return notemusique;
    }

    public void setNotemusique(int notemusique) {
        this.notemusique = notemusique;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }
}
