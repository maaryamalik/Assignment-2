package com.example.landingpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginupActivity extends AppCompatActivity {
    private EditText loginUsername, loginEmail, loginPassword, loginConfirmPassword;
    private Button btnloginUp, btnsign;
    FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
//        FirebaseApp.initializeApp(this);

        // Initialize the views
        loginUsername = findViewById(R.id.etUsername);
        loginEmail = findViewById(R.id.etEmail);
        loginPassword = findViewById(R.id.etPassword);
        loginConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnloginUp = findViewById(R.id.btnLoginUp);
        btnsign = findViewById(R.id.buttonsignUp);
        //Firebase intailization
        // Set up the button click listener
        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String username = loginUsername.getText().toString().trim();
                String email = loginEmail.getText().toString().trim();
                String password = loginPassword.getText().toString().trim();
                String confirmPassword = loginConfirmPassword.getText().toString().trim();

                // Validate input
                if (TextUtils.isEmpty(username)) {
                    loginUsername.setError("Username is required");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    loginEmail.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    loginPassword.setError("Password is required");
                    return;
                }
                if (password.length() < 6) {
                    loginPassword.setError("Password must be >=6 characters");
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    loginConfirmPassword.setError("Confirm Password is required");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    loginConfirmPassword.setError("Passwords do not match");
                    return;
                }

                // Show a success message
                Toast.makeText(LoginupActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginupActivity.this, Drawer.class));
                finish();
            }
        });
        btnloginUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the LoginActivity
                Intent intent = new Intent(LoginupActivity.this, SignActivity.class);
                startActivity(intent);
            }
        });
    }
}