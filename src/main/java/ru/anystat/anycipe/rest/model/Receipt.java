package ru.anystat.anycipe.rest.model;

/**
 * Created by ustits on 20.11.16.
 */
public class Receipt {

    private String name;
    private String[] ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }
}
