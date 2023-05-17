package com.example.elephanttrackapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

public class AddElephant extends AppCompatActivity {

    Button btnAdd,btnHome,btnEleDetails;
    EditText eID,dID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_elephant);

        eID=findViewById(R.id.editTextElephantID);
        dID=findViewById(R.id.editDeviceID);
        btnAdd=findViewById(R.id.buttonAdd);
        btnHome=findViewById(R.id.buttonHome);
        btnEleDetails=findViewById(R.id.buttonDetail);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
            }
        });
        btnEleDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ElephantDetails.class);
                startActivity(intent);
            }
        });
    }




    public void uploadData(){
        String EleID=eID.getText().toString();
        String DevID=dID.getText().toString();

        ElephantData Ed=new ElephantData(EleID,DevID);

        FirebaseDatabase.getInstance().getReference("Elephants Details").child(EleID)
                .setValue(Ed).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(AddElephant.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddElephant.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}