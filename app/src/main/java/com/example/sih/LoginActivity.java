package com.example.sih;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginbutton = findViewById(R.id.login_button);

//        loginbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Redirect to HR login activity
//                Intent intent = new Intent(LoginActivity.this, HrLoginActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        employeeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Redirect to Employee login activity
//                Intent intent = new Intent(LoginActivity.this, EmployeeLoginActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
