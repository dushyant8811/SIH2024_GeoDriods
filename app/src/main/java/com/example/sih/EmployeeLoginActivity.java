package com.example.sih;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class EmployeeLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        Button loginButton = findViewById(R.id.employee_login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add employee login logic here, for example, navigate to Employee dashboard
//                Intent intent = new Intent(EmployeeLoginActivity.this, EmployeeDashboardActivity.class);
//                startActivity(intent);
            }
        });
    }
}
