package com.example.landingpage;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Dashboard extends AppCompatActivity {
    Toolbar toolbar;
//run this
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        toolbar = findViewById(R.id.tool);
        //link xml with java
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setTitle("Dashboard");

    }

public boolean onCreateOptionsMenu(Menu menu) {
    new MenuInflater(this).inflate(R.menu.opt_menu, menu);
    return super.onCreateOptionsMenu(menu);
}

public boolean onOptionsItemSelected(MenuItem item) {
    int itemid = item.getItemId();
    if (itemid == R.id.opt1) {
        Toast.makeText(Dashboard.this, "Explore different Coffee ", Toast.LENGTH_SHORT).show();
    } else if (itemid == R.id.opt2) {
        Toast.makeText(Dashboard.this, "Services are provided soon ", Toast.LENGTH_SHORT).show();
    } else {
        Toast.makeText(Dashboard.this, "Logout successfully", Toast.LENGTH_SHORT).show();
    }
    return super.onOptionsItemSelected(item);
}
}

