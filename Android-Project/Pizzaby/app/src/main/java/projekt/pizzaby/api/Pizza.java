package projekt.pizzaby.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by robert on 15.02.2017.
 */

public class Pizza {

    @SerializedName("PizzaID")
    @Expose
    private Integer pizzaID;

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Ingredients")
    @Expose
    private List<Ingredient> ingredients = null;

    @SerializedName("PizzeriaPizzas")
    @Expose
    private List<PizzeriaPizza> pizzeriaPizzas = null;


    public Integer getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(Integer pizzaID) {
        this.pizzaID = pizzaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<PizzeriaPizza> getPizzeriaPizzas() {
        return pizzeriaPizzas;
    }

    public void setPizzeriaPizzas(List<PizzeriaPizza> pizzeriaPizzas) {
        this.pizzeriaPizzas = pizzeriaPizzas;
    }

}
