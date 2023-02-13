package com.example.app_mobile;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter<listAdapter.terrain_item>{
   private static RecyclerViewInterface recyclerViewInterface;
    ArrayList<Terrain> li = new ArrayList<>();

    //constructeur
    public listAdapter(ArrayList<Terrain> li, RecyclerViewInterface recyclerViewInterface) {
        this.li = li;
        this.recyclerViewInterface = recyclerViewInterface;
    }



    @NonNull
    @Override
    public terrain_item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_items , parent, false);
        return new terrain_item(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull terrain_item holder, int position) {
        Picasso.get().load(li.get(position).imageId).into(holder.img_terrain);
        holder.now_terrain.setText(li.get(position).name);
    }

    @Override
    public int getItemCount() {
        return li.size();
    }

    public  static class terrain_item extends RecyclerView.ViewHolder {

        ImageView img_terrain;
        TextView now_terrain;
        public terrain_item(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            img_terrain = itemView.findViewById(R.id.img_terrain);
            now_terrain = itemView.findViewById(R.id.now_terrain);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ( recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }

    }
}
