package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] pizzaNames, pizzaDescriptions;
    int[] pizzaIcons = {R.drawable.cheese, R.drawable.classic, R.drawable.ham,
            R.drawable.margarita, R.drawable.meat, R.drawable.mushrooms,
            R.drawable.olives, R.drawable.pepperoni, R.drawable.vegetarian, R.drawable.logo_pizza };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView = findViewById(R.id.PizzasList);
        pizzaNames = getResources().getStringArray(R.array.pizzaNames);
        pizzaDescriptions = getResources().getStringArray(R.array.pizzaDescriptions);
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this,
                pizzaNames, pizzaDescriptions, pizzaIcons);
        recyclerView.setAdapter(myRecyclerViewAdapter);
    }

    public void profileClick(View view) {
        Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}