package com.example.app_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listAdapterTransport extends RecyclerView.Adapter<listAdapterTransport.Transport_item> {
    private final RecyclerViewInterface recyclerViewInterface;
    ArrayList<Vehicule> li2 = new ArrayList<>();

    public listAdapterTransport(ArrayList<Vehicule> li2, RecyclerViewInterface recyclerViewInterface){
        this.li2 = li2;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    @NonNull
    @Override
    public Transport_item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v2 = inflater.inflate(R.layout.list_transport , parent, false);
        return new Transport_item(v2, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Transport_item holder, int position) {
        holder.imageTransport.setImageResource(li2.get(position).ImageTransport);
        holder.Transport.setText(li2.get(position).NomTransport);
        holder.DescrTransport.setText(li2.get(position).DescriptionTranspo);
    }

    @Override
    public int getItemCount() {

        return li2.size();
    }

    public static class Transport_item extends RecyclerView.ViewHolder{
          ImageView imageTransport;
          TextView Transport;
          TextView DescrTransport;
        public Transport_item(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);


            imageTransport = itemView.findViewById(R.id.img_transport);
            Transport = itemView.findViewById(R.id.transport);
            DescrTransport = itemView.findViewById(R.id.descript_vehic);

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
