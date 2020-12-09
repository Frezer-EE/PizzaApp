package com.example.pizza;

class PizzaListItem {
    Integer id;
    String name, description, structure;

    public PizzaListItem(Integer id, String name, String description, String strucure) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.structure = strucure;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStrucure() {
        return structure;
    }

    public void setStrucure(String strucure) {
        this.structure = strucure;
    }
}
