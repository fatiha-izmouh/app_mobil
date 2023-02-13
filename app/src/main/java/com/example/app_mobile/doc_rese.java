package com.example.app_mobile;

import android.widget.EditText;

public class doc_rese {
    String nomRespo,nomAssoc, typeActiv,dateActiv, heurDebut, heurFin;
    int codeIdentif;

    public doc_rese() {
    }



    public doc_rese(String nomRespo, String nomAssoc, String typeActiv, String dateActiv, String heurDebut, String heurFin, int codeIdentif) {
        this.nomRespo = nomRespo;
        this.nomAssoc = nomAssoc;
        this.typeActiv = typeActiv;
        this.dateActiv = dateActiv;
        this.heurDebut = heurDebut;
        this.heurFin = heurFin;
        this.codeIdentif = codeIdentif;
    }

    public String getNomRespo() {
        return nomRespo;
    }

    public void setNomRespo(String nomRespo) {
        this.nomRespo = nomRespo;
    }

    public String getNomAssoc() {
        return nomAssoc;
    }

    public void setNomAssoc(String nomAssoc) {
        this.nomAssoc = nomAssoc;
    }

    public String getTypeActiv() {
        return typeActiv;
    }

    public void setTypeActiv(String typeActiv) {
        this.typeActiv = typeActiv;
    }

    public String getDateActiv() {
        return dateActiv;
    }

    public void setDateActiv(String dateActiv) {
        this.dateActiv = dateActiv;
    }

    public String getHeurDebut() {
        return heurDebut;
    }

    public void setHeurDebut(String heurDebut) {
        this.heurDebut = heurDebut;
    }

    public String getHeurFin() {
        return heurFin;
    }

    public void setHeurFin(String heurFin) {
        this.heurFin = heurFin;
    }

    public int getCodeIdentif() {
        return codeIdentif;
    }

    public void setCodeIdentif(int codeIdentif) {
        this.codeIdentif = codeIdentif;
    }
}
