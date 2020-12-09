package com.example.pizza;

import java.util.ArrayList;

class PizzaList {
    ArrayList<PizzaListItem> pizza;

    public PizzaList(ArrayList<PizzaListItem> pizza) {
        this.pizza = pizza;
    }

    public ArrayList<PizzaListItem> getPizza() {
        return pizza;
    }

    public void setPizza(ArrayList<PizzaListItem> pizza) {
        this.pizza = pizza;
    }
}
