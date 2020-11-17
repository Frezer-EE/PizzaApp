package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void eMailChange(View view) {
    }

    public void PasswordChange(View view) {
    }

    public void Exit(View view) {
        Intent intent = new Intent(ProfileActivity.this, AuthorizationActivity.class);
        startActivity(intent);
    }
}