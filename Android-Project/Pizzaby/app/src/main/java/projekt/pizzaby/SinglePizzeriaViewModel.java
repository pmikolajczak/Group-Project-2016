package projekt.pizzaby;

import android.databinding.ObservableField;

import java.text.DecimalFormat;

import projekt.pizzaby.api.PizzeriaMapped;

/**
 * Created by robert on 15.02.2017.
 */

public class SinglePizzeriaViewModel {

    public PizzeriaMapped pizzeria;
    public ObservableField<String> nazwa = new ObservableField<>();
    public ObservableField<String> adres = new ObservableField<>();
    public ObservableField<String> telefon = new ObservableField<>();
    public ObservableField<String> odleglosc = new ObservableField<>();
    public ObservableField<String> minimalnaCena = new ObservableField<>();

    public SinglePizzeriaViewModel(PizzeriaMapped pizzeria) {
        this.pizzeria = pizzeria;

        DecimalFormat df = new DecimalFormat("#,##");

        nazwa.set(pizzeria.getName());
        adres.set("Adres: " + pizzeria.getAddress());
        telefon.set("Telefon: " + pizzeria.getPhone());
        odleglosc.set("Odległość: " + String.format("%.2f", pizzeria.getDistance()) + "km");
        minimalnaCena.set("Ceny od " + String.valueOf(pizzeria.getPriceMin()) + "zł");
    }
}
