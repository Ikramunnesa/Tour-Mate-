package com.example.tourmate;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tourmate.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(this, EventListActivity.class));
        }
    }

    public void loginUser(View view) {
        String email = binding.emailET.getText().toString();
        String pass = binding.passET.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                currentUser = firebaseAuth.getCurrentUser();
                updateUI("Logged in as "+currentUser.getEmail());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                updateUI(e.getLocalizedMessage());
            }
        });
    }

    public void signupUser(View view) {
        String email = binding.emailET.getText().toString();
        String pass = binding.passET.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                currentUser = firebaseAuth.getCurrentUser();
                updateUI("Logged in as "+currentUser.getEmail());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                updateUI(e.getLocalizedMessage());
            }
        });
    }

    private void updateUI(String msg) {
        binding.statusTV.setText(msg);
    }

}
