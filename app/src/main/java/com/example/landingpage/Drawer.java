package com.example.landingpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Drawer extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drawer);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationviews);
        toolbar = findViewById(R.id.tool);
        //Step1
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setTitle("Dashboard");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.opt1) {
//               loadFragment(new AFragment());.
                    //ForFragments
                    AFragment myFragment = new AFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, myFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else if (id == R.id.opt2) {
                    Toast.makeText(Drawer.this,"Services",Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(Drawer.this, SignActivity.class);
                    startActivity(intent);
                    Toast.makeText(Drawer.this,"Logout Successfully",Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemids = item.getItemId();
        if(itemids == R.id.optfav)
        {
            Toast.makeText(Drawer.this, "Favourite Coffees ", Toast.LENGTH_SHORT).show();
        }
        else if (itemids == R.id.opt1) {
            Toast.makeText(Drawer.this, "Explore different Coffee ", Toast.LENGTH_SHORT).show();
        } else if (itemids == R.id.opt2) {
            Toast.makeText(Drawer.this, "Services are provided soon ", Toast.LENGTH_SHORT).show();
        } else if (itemids == android.R.id.home) {
            super.onBackPressed();
        } else {
            Toast.makeText(Drawer.this, "Logout successfully", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void loadFragment(Fragment fragment) {
//        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        ft.add(R.id.container, fragment);
//        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

