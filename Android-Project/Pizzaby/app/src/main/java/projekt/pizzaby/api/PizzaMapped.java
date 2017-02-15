package projekt.pizzaby.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by robert on 15.02.2017.
 */

public class PizzaMapped {

    @SerializedName("PizzaID")
    @Expose
    private Integer pizzaID;

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Price")
    @Expose
    private Integer price;

    @SerializedName("Size")
    @Expose
    private Integer size;

    @SerializedName("Ingredients")
    @Expose
    private List<Ingredient> ingredients = null;

    @SerializedName("PizzeriaID")
    @Expose
    private Integer pizzeriaID;


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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getPizzeriaID() {
        return pizzeriaID;
    }

    public void setPizzeriaID(Integer pizzeriaID) {
        this.pizzeriaID = pizzeriaID;
    }
}