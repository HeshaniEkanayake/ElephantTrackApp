package com.example.elephanttrackapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {

    EditText edUserName,edEmail,edPassword,edConfirmPassword;
    Button btnSignup;
    TextView tvLogin;
    FirebaseAuth mAuth;

/*
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();

        if(currentUser!=null){
            Intent intent=new Intent(getApplicationContext(),UserHome.class);
            startActivity(intent);
            finish();
        }
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth=FirebaseAuth.getInstance();


        edUserName = findViewById(R.id.editTextUserName);
        edEmail = findViewById(R.id.editTextEmail);
        edPassword = findViewById(R.id.editTextPass);
        edConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        btnSignup = findViewById(R.id.buttonSignUp);
        tvLogin = findViewById(R.id.textViewSignUp);


        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = edUserName.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirmpassword = edConfirmPassword.getText().toString();

                if(TextUtils.isEmpty(username)){
                    Toast.makeText(Registration.this, "Enter Username", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Registration.this, "Enter email", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(password)||TextUtils.isEmpty(confirmpassword)){
                    Toast.makeText(Registration.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                if(password.equals(confirmpassword)){
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(Registration.this, "Account Created.",
                                                Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(getApplicationContext(),Login.class);
                                        startActivity(intent);
                                        finish();

                                    } else {

                                        Toast.makeText(Registration.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else {
                        Toast.makeText(getApplicationContext(), "Password didn't match", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
