package com.example.app_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LAsuivi extends RecyclerView.Adapter<LAsuivi.List_suivi> {

    ArrayList<Suivi2> li3 = new ArrayList<>();
    public LAsuivi(ArrayList<Suivi2> li3) {

        this.li3 = li3;

    }

    @NonNull
    @Override
    public List_suivi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v3 = inflater.inflate(R.layout.list_suivi , parent, false);
        return new LAsuivi.List_suivi(v3);
    }

    @Override
    public void onBindViewHolder(@NonNull List_suivi holder, int position) {
        holder.nom_terrain.setText(li3.get(position).nomTerrain);
        holder.activity.setText(li3.get(position).typeActivity);
        holder.dateReservation.setText(li3.get(position).dateReservation);
        holder.heurReservation.setText(li3.get(position).heurReservation);
        holder.getDateReservation2.setText(li3.get(position).getDateReservation2);
        holder.heur1.setText(li3.get(position).heur1);
        holder.heur2.setText(li3.get(position).heur2);
        holder.reponseReservation.setText(li3.get(position).reponseDeDemande);

    }

    @Override
    public int getItemCount() {
        return li3.size();
    }

    public static class List_suivi extends RecyclerView.ViewHolder {

        TextView nom_terrain;
        TextView activity;
        TextView dateReservation;
        TextView heurReservation;
        TextView getDateReservation2;
        TextView heur1;
        TextView heur2;
        TextView reponseReservation;
        public List_suivi(@NonNull View itemView) {
            super(itemView);
            nom_terrain = itemView.findViewById(R.id.typ_activity);
            activity = itemView.findViewById(R.id.activity);
            dateReservation= itemView.findViewById(R.id.dat_);
            heurReservation= itemView.findViewById(R.id.dat_heur);
            getDateReservation2= itemView.findViewById(R.id.dat2_);
            heur1= itemView.findViewById(R.id.heur1);
            heur2= itemView.findViewById(R.id.heur2);
            reponseReservation= itemView.findViewById(R.id.reponse);


        }
    }
}
