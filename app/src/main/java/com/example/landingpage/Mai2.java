package com.example.landingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mai2 extends AppCompatActivity {
    String userName, gmail, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mai2);
        Bundle extras = getIntent().getExtras();
        TextView usernames = findViewById(R.id.name);
        TextView usergmails = findViewById(R.id.gmail);
        TextView userpassword = findViewById(R.id.password);
        Button dashboards= (Button)findViewById(R.id.dashboardi);
        if (extras != null) {
            userName = extras.getString("keyname");
            gmail = extras.getString("keygmail");
            password = extras.getString("keypassword");
            // and get whatever type user account id is
             usernames.setText(userName);
            usergmails.setText(gmail);
            userpassword.setText(password);

        }
        //firebase kaha py hia ?
        dashboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mai2.this,Drawer.class);
                startActivity(intent);
            }
        });
    }

    }
