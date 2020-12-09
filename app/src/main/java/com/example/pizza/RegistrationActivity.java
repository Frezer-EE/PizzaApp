package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText regLogin, regPassword, regRepeatPassword, regEMail;
    IRetrofit2 iRetrofit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        regLogin = findViewById(R.id.editTextRegLogin);
        regPassword = findViewById(R.id.editTextRegPass);
        regRepeatPassword = findViewById(R.id.editTextRegPassRepeat);
        regEMail = findViewById(R.id.editTextRegEMail);
        iRetrofit2 = RetrofitApiBuilder.getInterface();
    }

    public void toMainMenuActivity(View view) {
        String strRegLogin = regLogin.getText().toString();
        String strRegPassword = regPassword.getText().toString();
        String strRegRepeatPassword = regRepeatPassword.getText().toString();
        String strRegEMail = regEMail.getText().toString();

        if (!strRegLogin.equals("") && !strRegPassword.equals("") && !strRegEMail.equals("")) {
            if (strRegPassword.equals(strRegRepeatPassword)) {
                if (strRegEMail.indexOf("@") > 0) {
//                    Toast.makeText(this, "Регистрация прошла успешно", Toast.LENGTH_LONG).show();
                    Call<UserResponse> responseCall = iRetrofit2.registrationUser(strRegLogin,
                            strRegEMail, strRegPassword);
                    responseCall.enqueue(new Callback<UserResponse>() {
                        @Override
                        public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                            Intent intent = new Intent(RegistrationActivity.this, AuthorizationActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<UserResponse> call, Throwable t) {

                        }
                    });

                }
                else {
                    Toast.makeText(this, "Неверный формат почты", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "Поля логина, пароля и/или почты пустые", Toast.LENGTH_LONG).show();
        }
    }

    public void toAutorizationActivity(View view) {
        Intent intent = new Intent(RegistrationActivity.this, AuthorizationActivity.class);
        startActivity(intent);
    }
}