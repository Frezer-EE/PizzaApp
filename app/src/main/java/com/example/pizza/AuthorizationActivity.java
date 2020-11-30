package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AuthorizationActivity extends AppCompatActivity {

    EditText login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        login = findViewById(R.id.editTextLogin);
        password = findViewById(R.id.editTextPassword);
    }

    public void signing(View view) {
        String myLogin = login.getText().toString();
        String myPassword = password.getText().toString();

        if (!myLogin.equals("") && !myPassword.equals("")) {
            if (myLogin.equals("admin") && myPassword.equals("admin")) {
                Intent intent = new Intent(AuthorizationActivity.this, BottomNavigationActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Логин или пароль неверные", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "Поля не должны быть пустыми", Toast.LENGTH_LONG).show();
        }
    }

    public void toRegistrationActivity(View view) {
        Intent intent = new Intent(AuthorizationActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }
}