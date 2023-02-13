package com.example.app_mobile;

public class Suivi2 {
    String nomTerrain;
    String typeActivity;
    String dateReservation;
    String heurReservation;
    String getDateReservation2;
    String heur1;
    String heur2;
    String reponseDeDemande;

    public Suivi2(String nomTerrain, String typeActivity, String dateReservation, String heurReservation, String getDateReservation2, String heur1, String heur2, String reponseDeDemande) {
        this.nomTerrain = nomTerrain;
        this.typeActivity = typeActivity;
        this.dateReservation = dateReservation;
        this.heurReservation = heurReservation;
        this.getDateReservation2 = getDateReservation2;
        this.heur1 = heur1;
        this.heur2 = heur2;
        this.reponseDeDemande = reponseDeDemande;
    }

    public Suivi2() {
    }

    public String getNomTerrain() {
        return nomTerrain;
    }

    public void setNomTerrain(String nomTerrain) {
        this.nomTerrain = nomTerrain;
    }

    public String getTypeActivity() {
        return typeActivity;
    }

    public void setTypeActivity(String typeActivity) {
        this.typeActivity = typeActivity;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getHeurReservation() {
        return heurReservation;
    }

    public void setHeurReservation(String heurReservation) {
        this.heurReservation = heurReservation;
    }

    public String getGetDateReservation2() {
        return getDateReservation2;
    }

    public void setGetDateReservation2(String getDateReservation2) {
        this.getDateReservation2 = getDateReservation2;
    }

    public String getHeur1() {
        return heur1;
    }

    public void setHeur1(String heur1) {
        this.heur1 = heur1;
    }

    public String getHeur2() {
        return heur2;
    }

    public void setHeur2(String heur2) {
        this.heur2 = heur2;
    }

    public String getReponseDeDemande() {
        return reponseDeDemande;
    }

    public void setReponseDeDemande(String reponseDeDemande) {
        this.reponseDeDemande = reponseDeDemande;
    }
}
