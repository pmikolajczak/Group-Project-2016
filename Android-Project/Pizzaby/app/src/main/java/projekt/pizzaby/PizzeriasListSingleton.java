package projekt.pizzaby;

import java.util.List;

import projekt.pizzaby.api.PizzeriaMapped;

/**
 * Created by robert on 15.02.2017.
 */

public class PizzeriasListSingleton {

    private static PizzeriasListSingleton ourInstance = new PizzeriasListSingleton();

    public List<PizzeriaMapped> list;

    private PizzeriasListSingleton() {

    }

    public static PizzeriasListSingleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new PizzeriasListSingleton();
        }
        return ourInstance;
    }

    public List<PizzeriaMapped> getList() {
        return list;
    }

    public void setList(List<PizzeriaMapped> list) {
        this.list = list;
    }
}
