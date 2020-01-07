package com.example.ric.domain;

public class Recette {

    private long id;
    private String name;
    private String ingredients;
    private String preparation;
    private String step;

    public Recette(long id, String name, String ingredients, String preparation, String step) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.step = step;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
}
