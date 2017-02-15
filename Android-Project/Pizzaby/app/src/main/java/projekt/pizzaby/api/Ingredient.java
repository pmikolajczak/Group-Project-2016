package projekt.pizzaby.api;

import java.util.List;

/**
 * Created by robert on 15.02.2017.
 */

public class Ingredient {


    private Integer ingredientID;
    private String name;
    private List<PizzaMapped> pizzas = null;

    public Integer getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(Integer ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PizzaMapped> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaMapped> pizzas) {
        this.pizzas = pizzas;
    }

}
