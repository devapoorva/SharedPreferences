package com.apoorv.sharedpreferences.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.apoorv.sharedpreferences.R;
import com.apoorv.sharedpreferences.storage.SessionManager;

/**
 * Created by Apoorv Vardhman on 26-11-2019
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  developerapoorv.xyz
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */

public class Dashboard extends AppCompatActivity {

    TextView txtName,txtEmail,txtPassword;

    SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        sessionManager = new SessionManager(Dashboard.this);

        txtName = findViewById(R.id.txt_name);
        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);

        txtName.setText(sessionManager.getName());
        txtEmail.setText(sessionManager.getEmail());
        txtPassword.setText(sessionManager.getPassword());

    }


    public void logout(View view) {
        sessionManager.clearData();
        startActivity(new Intent(Dashboard.this,MainActivity.class));
        finish();
    }
}
