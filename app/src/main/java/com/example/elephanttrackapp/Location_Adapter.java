package com.example.elephanttrackapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Location_Adapter extends FirebaseRecyclerAdapter<LocationData,Location_Adapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Location_Adapter(@NonNull FirebaseRecyclerOptions<LocationData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull LocationData model) {
        holder.latitude.setText(model.getLatitude());
        holder.longitude.setText(model.getLongitude());
        holder.address.setText(model.getAddress());
        holder.date.setText(model.getDAT());
        holder.eleID.setText(model.getEleId());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.location,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView latitude,longitude,address,date,eleID;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            latitude=(TextView)itemView.findViewById(R.id.latitude);
            longitude=(TextView)itemView.findViewById(R.id.longitude);
            address=(TextView)itemView.findViewById(R.id.address);
            date=(TextView)itemView.findViewById(R.id.date);
            eleID=(TextView)itemView.findViewById(R.id.EleID);
        }
    }
}


/*
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Location_Adapter extends RecyclerView.Adapter<Location_Adapter.MyViewHolder> {
    Context context;
    ArrayList<LocationData> list;

    public Location_Adapter(Context context, ArrayList<LocationData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.location,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Location_Adapter.MyViewHolder holder, int position) {
        LocationData loc=list.get(position);
        holder.latitude.setText(loc.getLatitude());
        holder.longitude.setText(loc.getLongitude());
        holder.address.setText(loc.getAddress());
        holder.date.setText(loc.getDAT());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView latitude,longitude,address,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            latitude=itemView.findViewById(R.id.latitude);
            longitude=itemView.findViewById(R.id.longitude);
            address=itemView.findViewById(R.id.address);
            date=itemView.findViewById(R.id.date);
        }
    }
}
*/