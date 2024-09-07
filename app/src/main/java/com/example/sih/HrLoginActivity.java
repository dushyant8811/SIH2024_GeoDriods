package com.example.sih;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class HrLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr_login);

        Button loginButton = findViewById(R.id.hr_login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add HR login logic here, for example, navigate to HR dashboard
                //Intent intent = new Intent(HRLoginActivity.this, HRDashboardActivity.class);
                //startActivity(intent);
            }
        });
    }
}
