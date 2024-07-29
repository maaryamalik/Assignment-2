package com.example.landingpage;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SignActivity extends AppCompatActivity {
    private Button btnlogin,btnsignup;
FirebaseAuth firebaseAuth;
    private EditText username, gmail, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginup);
        password = findViewById(R.id.Passwords);
        gmail = findViewById(R.id.Gmail);
        username = findViewById(R.id.Username);
        btnlogin = findViewById(R.id.bottonlogin);
        btnsignup=findViewById(R.id.buttonsignUp);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernames = username.getText().toString();
                String gmails = gmail.getText().toString();
                String passwords = password.getText().toString();
                //to link from one activity to another activity
                // Validate input
                if (TextUtils.isEmpty(usernames)) {
                    username.setError("Username is required");
                    return;
                }

                if (TextUtils.isEmpty(gmails)) {
                    gmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(passwords) ){
                    password.setError("Password is required");
                    return;
                }
                if (passwords.length()<6 ) {
                    password.setError("Password must be >=6 characters");
                    return;
                }
            }
            });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the LoginActivity
                Intent intent = new Intent(SignActivity.this, LoginupActivity.class);
                startActivity(intent);
//                Toast.makeText(SignActivity.this, "dhkasf", Toast.LENGTH_SHORT).show();
            }
        });
        }
    }

