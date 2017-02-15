package projekt.pizzaby.api;

/**
 * Created by robert on 15.02.2017.
 */

public class PizzeriaPizza {

    private Integer pizzeriaPizzaID;
    private Integer pizzeriaID;
    private Integer pizzaID;
    private Integer price;
    private Integer size;
    private Pizzeria pizzeria;

    public Integer getPizzeriaPizzaID() {
        return pizzeriaPizzaID;
    }

    public void setPizzeriaPizzaID(Integer pizzeriaPizzaID) {
        this.pizzeriaPizzaID = pizzeriaPizzaID;
    }

    public Integer getPizzeriaID() {
        return pizzeriaID;
    }

    public void setPizzeriaID(Integer pizzeriaID) {
        this.pizzeriaID = pizzeriaID;
    }

    public Integer getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(Integer pizzaID) {
        this.pizzaID = pizzaID;
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

    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    public void setPizzeria(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

}
