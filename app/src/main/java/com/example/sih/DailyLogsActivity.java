package com.example.sih;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import android.provider.MediaStore;

import android.view.MenuItem;


public class DailyLogsActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    // Define an ActivityResultLauncher for requesting permissions
    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // Permission is granted, proceed with camera action
                    dispatchTakePictureIntent();
                } else {
                    // Permission is denied, show a message to the user
                    Toast.makeText(this, "Camera permission is required to use this feature.", Toast.LENGTH_LONG).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_logs);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Menu");

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Set up the navigation icon
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            toolbar.setNavigationIcon(R.drawable.ic_menu);
            toolbar.setNavigationOnClickListener(v -> {
                if (drawerLayout != null) {
                    drawerLayout.openDrawer(navigationView);
                }
            });
        }

        // Set up navigation item selection listener
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                // Start MainActivity when Home is clicked
                Intent intent = new Intent(DailyLogsActivity.this, MainActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
//            else if (id == R.id.nav_profile) {
//                // Handle profile item click
//                // Intent intent = new Intent(DailyLogsActivity.this, ProfileActivity.class);
//                // startActivity(intent);
//                // drawerLayout.closeDrawer(navigationView);
//                // return true;
//            }
            else if (id == R.id.nav_capture) {
                // Handle capture item click
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    // Permission is already granted, proceed with camera action
                    dispatchTakePictureIntent();
                } else {
                    // Request permission
                    requestPermissionLauncher.launch(Manifest.permission.CAMERA);
                }
                return true;
            } else if (id == R.id.nav_daily_logs) {
                // Handle daily logs item click
            }
            else if (id == R.id.nav_workplace_locations) {
                // Handle workplace locations item click
            }
            else if (id == R.id.nav_manager_approval) {
                // Handle manager approval item click
            }
            else if (id == R.id.nav_admin_panel) {
                // Handle admin panel item click
            }
//            else if (id == R.id.nav_settings) {
//                // Handle settings item click
//            }
            else if (id == R.id.nav_logout) {
                // Handle logout item click
            }
            return false;
        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

}
