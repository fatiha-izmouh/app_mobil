package com.example.app_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashBord extends AppCompatActivity implements View.OnClickListener {


    private CardView card1, card2, card3, card4, card5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);

        card1 = (CardView) findViewById(R.id.btnReservation);
        card2 = (CardView) findViewById(R.id.btnSuivi);
        card3 = (CardView) findViewById(R.id.btnTransport);

        card4 = (CardView) findViewById(R.id.btnMap);
        card5 = (CardView) findViewById(R.id.btnProfil);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);

        card4.setOnClickListener(this);
        card5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.btnReservation:
                i = new Intent(this, Reservation.class);
                startActivity(i);
                break;
            case R.id.btnSuivi:
                i = new Intent(this, Suivi.class);
                startActivity(i);
                break;
            case R.id.btnTransport:
                i = new Intent(this, Transport.class);
                startActivity(i);
                break;
            case R.id.btnMap:
                i = new Intent(this, Map.class);
                startActivity(i);
                break;
            case R.id.btnProfil:
                i = new Intent(this, Profile.class);
                startActivity(i);
                break;
        }
    }
}