package com.example.elephanttrackapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LocationDetails extends AppCompatActivity {

    Spinner spinner;
    ArrayList<String> list;
    DatabaseReference spinnerRef;
    ArrayAdapter<String> adapter;
    ValueEventListener listener;
    Button search;

    DatabaseReference to;
    RecyclerView recyclerView;
    Location_Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        spinner=findViewById(R.id.spinner);
        spinnerRef= FirebaseDatabase.getInstance().getReference("Elephants Details");
        list=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);
        fetchData();

        search=findViewById(R.id.btnSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseRecyclerOptions<LocationData> options=
                        new FirebaseRecyclerOptions.Builder<LocationData>()
                                .setQuery(FirebaseDatabase.getInstance().getReference(spinner.getSelectedItem().toString()),LocationData.class)
                                .build();
                to=FirebaseDatabase.getInstance().getReference(spinner.getSelectedItem().toString());
                myAdapter=new Location_Adapter(options);
                recyclerView.setAdapter(myAdapter);
                myAdapter.startListening();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
        myAdapter.stopListening();
    }

    public void fetchData(){
        listener=spinnerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot mydata: snapshot.getChildren())
                    list.add(mydata.child("eleID").getValue().toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}