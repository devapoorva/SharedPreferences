package com.apoorv.sharedpreferences.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.apoorv.sharedpreferences.R;
import com.apoorv.sharedpreferences.storage.SessionManager;

public class MainActivity extends AppCompatActivity {

    EditText edtName,edtEmail,edtPassword;
    private String name,email,password;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(MainActivity.this);

        if(!sessionManager.getEmail().isEmpty())
        {
            startActivity(new Intent(MainActivity.this,Dashboard.class));
            finish();
        }

        setContentView(R.layout.activity_main);


        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword  = findViewById(R.id.edt_password);



    }

    public void register(View view) {
        name = edtName.getText().toString().trim();
        email = edtEmail.getText().toString().trim();
        password = edtPassword.getText().toString();

        sessionManager.register(email,password,name);
        Toast.makeText(getApplicationContext(),"register Successfully",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,Dashboard.class));
        finish();
    }
}
