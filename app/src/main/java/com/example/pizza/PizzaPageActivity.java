package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaPageActivity extends AppCompatActivity {
    ImageView pizzaIcon;
    TextView pizzaName, pizzaDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_page);
        pizzaIcon = findViewById(R.id.pizzaPageIcon);
        pizzaName = findViewById(R.id.pizzaPageName);
        pizzaDescription = findViewById(R.id.pizzaPageDescription);
        pizzaIcon.setImageResource(getIntent().getIntExtra("pizzaIcon", R.drawable.no_icon));
        pizzaName.setText(getIntent().getStringExtra("pizzaName"));
        pizzaDescription.setText(getIntent().getStringExtra("pizzaDescription"));
    }
}