package com.example.app_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listAdapterSuivi extends RecyclerView.Adapter<listAdapterSuivi.suivi_item> {

    ArrayList<Suivi2> li = new ArrayList<>();
   public listAdapterSuivi(ArrayList<Suivi2> li){
       this.li=li;
   }


    @NonNull
    @Override
    public listAdapterSuivi.suivi_item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_suivi , parent, false);
        return new suivi_item(v);
    }

    @Override
    public void onBindViewHolder(@NonNull listAdapterSuivi.suivi_item holder, int position) {
        holder.nomTerrain.setText(li.get(position).nomTerrain);
        holder.typeActivity.setText(li.get(position).typeActivity);
        holder.dateReservation.setText(li.get(position).dateReservation);
        holder.heurReservation.setText(li.get(position).heurReservation);
        holder.getDateReservation2.setText(li.get(position).getDateReservation2);
        holder.heur1.setText(li.get(position).heur1);
        holder.heur2.setText(li.get(position).heur2);
        holder.reponseDeDemande.setText(li.get(position).reponseDeDemande);
    }

    @Override
    public int getItemCount() {
        return li.size();
    }

    public static class suivi_item extends RecyclerView.ViewHolder{

        TextView nomTerrain,typeActivity,dateReservation,heurReservation,getDateReservation2,heur1,heur2,reponseDeDemande;

        public suivi_item(@NonNull View itemView) {
            super(itemView);
            nomTerrain=(TextView) itemView.findViewById(R.id.nm_terrain);
            typeActivity=(TextView) itemView.findViewById(R.id.nm_activity);
            dateReservation=(TextView) itemView.findViewById(R.id.dat_res);
            heurReservation=(TextView) itemView.findViewById(R.id.dat_heur);
            getDateReservation2=(TextView) itemView.findViewById(R.id.dat_pour);
            heur1=(TextView) itemView.findViewById(R.id.heur1);
            heur2=(TextView) itemView.findViewById(R.id.heur2);
            reponseDeDemande=(TextView) itemView.findViewById(R.id.reponse);
        }
    }
}
