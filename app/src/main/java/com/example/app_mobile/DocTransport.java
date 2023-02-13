package com.example.app_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DocTransport extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText nomRespo;
    EditText nomAssoc;
    EditText codeIdentif;
    Spinner vehicule;
    EditText dateActiv;
    EditText heurDebut;
    EditText heurFin;
    Button btnvalider;
    DatePickerDialog.OnDateSetListener setListener;
    int mHour, mMinute;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_transport);


        nomRespo = (EditText) findViewById(R.id.nom_responsable2);
        nomAssoc = (EditText) findViewById(R.id.nom_association2);
        codeIdentif = (EditText) findViewById(R.id.code_identifiant2);
        vehicule = (Spinner) findViewById(R.id.type_activity2);
        heurDebut = (EditText) findViewById(R.id.hour12);
        heurFin = (EditText) findViewById(R.id.hour22);
        dateActiv = (EditText) findViewById(R.id.date2);
        btnvalider = (Button) findViewById(R.id.reservee2);
        dialog = new Dialog(DocTransport.this);



        dialog.setContentView(R.layout.popup);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.shape_champs3));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
        dialog.getWindow().getAttributes().windowAnimations= R.style.animation;

        btnvalider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);






        heurDebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v == heurDebut) {
                    final Calendar calendar1 = Calendar.getInstance();
                    mHour = calendar1.get (Calendar.HOUR);
                    mMinute = calendar1.get (Calendar.MINUTE);
                    TimePickerDialog timePickerDialog = new TimePickerDialog(DocTransport.this  , new TimePickerDialog.OnTimeSetListener() {
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
                    TimePickerDialog timePickerDialog = new TimePickerDialog(DocTransport.this  , new TimePickerDialog.OnTimeSetListener() {
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
                        DocTransport.this, new DatePickerDialog.OnDateSetListener() {
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

        Spinner spinner = findViewById(R.id.type_activity2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cars, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}

