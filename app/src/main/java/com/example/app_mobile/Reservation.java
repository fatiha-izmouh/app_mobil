package com.example.app_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Reservation extends AppCompatActivity implements RecyclerViewInterface{

    // Initialize an ArrayList to store Terrain objects
    ArrayList<Terrain> li = new ArrayList<>();
    // Initialize the adapter for the RecyclerView
    listAdapter adapter ;
    // Initialize the RecyclerView
    RecyclerView list_terrain ;
    // Initialize the DatabaseReference object to access the Firebase database
    DatabaseReference myRef;
    // Initialize the Terrain object
    Terrain t;
    // Declare two String variables to store the image URL and name of the Terrain object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        // Get an instance of the Firebase database and reference the "stadiums" node
        myRef =  FirebaseDatabase.getInstance().getReference("stadiums");

        // Initialize the RecyclerView
        list_terrain = findViewById(R.id.list_terrain);
        adapter = new listAdapter(li, this);
        list_terrain.setAdapter(adapter);
        // Set the layout manager for the RecyclerView
        GridLayoutManager g = new GridLayoutManager( this, 1);
        list_terrain.setLayoutManager(g);
        // Listen for changes in the data stored in the Firebase database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Clear the list of terrains before updating it
                li.clear();
                // Iterate through the list of terrains stored in the Firebase database
                for (DataSnapshot item:
                     dataSnapshot.getChildren()) {
                    // Create a new Terrain object
                    t = new Terrain();
                    // Get the image URL and name of the terrain from the Firebase database
                    t.setImageId(""+item.child("imageurl").getValue());
                    t.setName(""+item.child("name").getValue());
                    // Add the Terrain object to the list
                    li.add(t);
                    // Notify the adapter that the list has been updated
                    adapter.notifyDataSetChanged();
                    //Toast.makeText(Reservation.this, ""+t.getName()+"\n"+t.getImageId(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
            }
        });

    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(Reservation.this, Document.class);
        startActivity(intent);
    }
}