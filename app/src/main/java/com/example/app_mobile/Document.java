package com.example.app_mobile;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class Document extends AppCompatActivity {

    EditText nomRespo;
    EditText nomAssoc;
    EditText codeIdentif;
    EditText typeActiv;
    EditText dateActiv;
    EditText heurDebut;
    EditText heurFin;
    Button btnvalider;
    ArrayList li = new ArrayList();
    DatePickerDialog.OnDateSetListener setListener;
    int mHour, mMinute;
    Dialog dialog;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference().child("doc");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

        nomRespo = (EditText) findViewById(R.id.nom_responsable);
        nomAssoc = (EditText) findViewById(R.id.nom_association);
        codeIdentif = (EditText) findViewById(R.id.code_identifiant);
        typeActiv = (EditText) findViewById(R.id.type_activity);
        heurDebut = (EditText) findViewById(R.id.hour1);
        heurFin = (EditText) findViewById(R.id.hour2);
        dateActiv = (EditText) findViewById(R.id.date);
        btnvalider = (Button) findViewById(R.id.reservee);
        dialog = new Dialog(Document.this);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dialog.setContentView(R.layout.popup);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.shape_champs3));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
        dialog.getWindow().getAttributes().windowAnimations= R.style.animation;

        btnvalider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom_resp = nomRespo.getText().toString();
                String nom_Assoc = nomAssoc.getText().toString();
                int code_Identif = Integer.parseInt(codeIdentif.getText().toString());
                String type_Activ = typeActiv.getText().toString();
                String heur_Debut = heurDebut.getText().toString();
                String heur_Fin = heurFin.getText().toString();
                String date_Activ = dateActiv.getText().toString();

                li.add(nom_resp);
                li.add(nom_Assoc);
                li.add(code_Identif);
                li.add(type_Activ);
                li.add(heur_Debut);
                li.add(heur_Fin);
                li.add(date_Activ);
                root.push().setValue(li);

                dialog.show();
            }
        });


        heurDebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == heurDebut) {
                    final Calendar calendar1 = Calendar.getInstance();
                    mHour = calendar1.get (Calendar.HOUR);
                    mMinute = calendar1.get (Calendar.MINUTE);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(Document.this  , new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            heurDebut.setText( hourOfDay+":"+minute);
                        }
                    },mHour,mMinute,false);
                    timePickerDialog.show();
                }
            }
        });

        heurFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == heurFin) {
                    final Calendar calendar1 = Calendar.getInstance();
                    mHour = calendar1.get (Calendar.HOUR);
                    mMinute = calendar1.get (Calendar.MINUTE);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(Document.this  , new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            heurFin.setText( hourOfDay+":"+minute);
                        }
                    },mHour,mMinute,false);
                    timePickerDialog.show();
                }
            }
        });

        dateActiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Document.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        dateActiv.setText(date);
                    }

                },year,month,day);
                datePickerDialog.show();

            }
        });
    }
}