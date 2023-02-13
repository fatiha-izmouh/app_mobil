package com.example.app_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Suivi extends AppCompatActivity {

    ArrayList<Suivi2> li = new ArrayList<Suivi2>();
    listAdapterSuivi adapter;
    RecyclerView list_suivi;
    DatabaseReference myRef;
    Suivi2 s;
    String nomTerrain,typeActivity,dateReservation,heurReservation,getDateReservation2,heur1,heur2,reponseDeDemande;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivi);

        myRef= FirebaseDatabase.getInstance().getReference("doc");

        list_suivi = findViewById(R.id.list_suivi);
        adapter =new listAdapterSuivi(li);
        list_suivi.setAdapter(adapter);

        GridLayoutManager g =new GridLayoutManager(this,1);
        list_suivi.setLayoutManager(g);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                li.clear();
                for (DataSnapshot item: dataSnapshot.getChildren()) {
                    // Create a new Terrain object
                    s = new Suivi2();
                    // Get the image URL and name of the terrain from the Firebase database
                    s.setNomTerrain(""+item.child("0").getValue());
                    s.setTypeActivity(""+item.child("1").getValue());
                    s.setDateReservation(""+item.child("2").getValue());
                    s.setHeurReservation(""+item.child("3").getValue());
                    s.setGetDateReservation2(""+item.child("4").getValue());
                    s.setDateReservation(""+item.child("5").getValue());
                    li.add(s);
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        })

    }
}