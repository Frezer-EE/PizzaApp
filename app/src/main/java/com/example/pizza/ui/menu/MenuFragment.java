package com.example.pizza.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza.MyRecyclerViewAdapter;
import com.example.pizza.ProfileActivity;
import com.example.pizza.R;

public class MenuFragment extends Fragment {

    RecyclerView recyclerView;
    String[] pizzaNames, pizzaDescriptions;
    ImageView profile;

    int[] pizzaIcons = {R.drawable.cheese, R.drawable.classic, R.drawable.ham,
            R.drawable.margarita, R.drawable.meat, R.drawable.mushrooms,
            R.drawable.olives, R.drawable.pepperoni, R.drawable.vegetarian, R.drawable.logo_pizza };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_menu, container, false);

        pizzaNames = getResources().getStringArray(R.array.pizzaNames);
        pizzaDescriptions = getResources().getStringArray(R.array.pizzaDescriptions);
        recyclerView = root.findViewById(R.id.PizzasList);
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(getActivity(),
                pizzaNames, pizzaDescriptions, pizzaIcons);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        profile = root.findViewById(R.id.UserImage);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}