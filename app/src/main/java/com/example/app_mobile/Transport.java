package com.example.app_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class Transport extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<Vehicule> li2 = new ArrayList<Vehicule>();
    listAdapterTransport adapter ;
    RecyclerView list_transport ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        list_transport = findViewById(R.id.list_transport);
        li2.add(new Vehicule("Docker", R.drawable.testtranspo, "6 Places"));
        li2.add(new Vehicule("Mercedes", R.drawable.testtranspo, "14 places"));
        li2.add(new Vehicule("honda", R.drawable.testtranspo2, "20 places"));

        adapter = new listAdapterTransport(li2, this);
        list_transport.setAdapter(adapter);
        GridLayoutManager g = new GridLayoutManager( this, 1);
        list_transport.setLayoutManager(g);


    }



    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Transport.this, DocTransport.class);
        startActivity(intent);

    }
}