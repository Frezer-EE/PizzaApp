package com.example.pizza;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    String[] pizzaNames, pizzaDescriptions;
    int[] pizzaIcons;
    Context context;

    public MyRecyclerViewAdapter(Context context, String[] pizzaNames, String[] pizzaDescriptions, int[] pizzaIcons) {
        this.pizzaNames = pizzaNames;
        this.pizzaDescriptions = pizzaDescriptions;
        this.pizzaIcons = pizzaIcons;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View root = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.pizzaName.setText(pizzaNames[position]);
        holder.pizzaDescription.setText(pizzaDescriptions[position]);
        holder.pizzaIcon.setImageResource(pizzaIcons[position]);
        holder.pizzaRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PizzaPageActivity.class);
                intent.putExtra("pizzaIcon", pizzaIcons[position]);
                intent.putExtra("pizzaName", pizzaNames[position]);
                intent.putExtra("pizzaDescription", pizzaDescriptions[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pizzaNames.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView pizzaName, pizzaDescription;
        ImageView pizzaIcon;
        LinearLayout pizzaRow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pizzaName = itemView.findViewById(R.id.PizzaName);
            pizzaDescription = itemView.findViewById(R.id.PizzaDescription);
            pizzaIcon = itemView.findViewById(R.id.PizzaIcon);
            pizzaRow = itemView.findViewById(R.id.pizzaRow);
        }
    }
}
