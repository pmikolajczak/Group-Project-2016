package projekt.pizzaby;

import android.databinding.ObservableField;

import java.util.List;

import projekt.pizzaby.api.Ingredient;
import projekt.pizzaby.api.PizzaMapped;

/**
 * Created by robert on 15.02.2017.
 */

public class SinglePizzaViewModel {

    public PizzaMapped pizza;
    public ObservableField<String> nazwa = new ObservableField<>("");
    public ObservableField<String> cena = new ObservableField<>("");
    public ObservableField<String> rozmiar = new ObservableField<>("");
    public ObservableField<String> skladniki = new ObservableField<>("");

    public SinglePizzaViewModel(PizzaMapped singlePizza) {
        pizza = singlePizza;

        nazwa.set(pizza.getName());
        cena.set("Cena: " + String.valueOf(pizza.getPrice()) + "zł");
        rozmiar.set("Średnica: " + String.valueOf(pizza.getSize()) + "cm");

        String tempSkladniki = "";
        List<Ingredient> skladnikiList = pizza.getIngredients();
        for (Ingredient skladnik : skladnikiList) {
            tempSkladniki = tempSkladniki.concat(skladnik.getName() + ", ");
        }

        if (tempSkladniki.length() > 2) {
            skladniki.set("Składniki: " + tempSkladniki.substring(0, tempSkladniki.length() - 2));
        }

    }


}
