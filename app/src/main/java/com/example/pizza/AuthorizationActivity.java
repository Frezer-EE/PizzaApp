package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AuthorizationActivity extends AppCompatActivity {

    EditText login, password;
    IRetrofit2 iRetrofit2;
    SharedPreferences sharedPreferences;
    CheckBox checkBox;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        login = findViewById(R.id.editTextLogin);
        password = findViewById(R.id.editTextPassword);
        iRetrofit2 = RetrofitApiBuilder.getInterface();
        checkBox = findViewById(R.id.checkBox);
        sharedPreferences = getSharedPreferences("main", MODE_PRIVATE);
        Boolean save = sharedPreferences.getBoolean("save", false);
        if (save) {
            Intent intent = new Intent(AuthorizationActivity.this, BottomNavigationActivity.class);
            startActivity(intent);
        }
    }

    public void signing(View view) {
        String myLogin = login.getText().toString();
        String myPassword = password.getText().toString();
        editor = sharedPreferences.edit();
        editor.putString("name", myLogin);
        editor.apply();

        if (checkBox.isChecked()) {
            editor = sharedPreferences.edit();
            editor.putBoolean("save", true);
            editor.apply();
        }
        else {
            editor = sharedPreferences.edit();
            editor.putBoolean("save", false);
            editor.apply();
        }

        if (!myLogin.equals("") && !myPassword.equals("")) {
            Call<AuthResponse> authResponseCall = iRetrofit2.authorizationUser(myLogin, myPassword);
            authResponseCall.enqueue(new Callback<AuthResponse>() {
                @Override
                public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                    if (response.isSuccessful()) {
                        Intent intent = new Intent(AuthorizationActivity.this, BottomNavigationActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplication(), "Login or password invalid", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<AuthResponse> call, Throwable t) {
                    Toast.makeText(getApplication(), "Server error", Toast.LENGTH_LONG).show();
                }
            });
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